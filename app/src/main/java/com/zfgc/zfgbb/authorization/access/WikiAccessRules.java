package com.zfgc.zfgbb.authorization.access;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.authorization.AuthorityTiers;
import com.zfgc.zfgbb.model.users.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WikiAccessRules {

	private final AuthorityTiers authorityTiers;

	public record NamespaceEditPolicy(boolean systemManaged, Optional<String> editPermissionCode) {}

	public enum NamespaceEditDenialReason {
		SYSTEM_MANAGED,
		MISSING_PERMISSION,
		NO_EDIT_POLICY
	}

	public record NamespaceEditDenial(NamespaceEditDenialReason reason, String namespace,
			Optional<String> requiredPermissionCode) {

		public String message() {
			return switch (reason) {
				case SYSTEM_MANAGED ->
					"Namespace '" + namespace + "' is system managed and cannot be edited through the wiki";
				case MISSING_PERMISSION ->
					"Namespace '" + namespace + "' requires the " + requiredPermissionCode.orElseThrow() + " permission";
				case NO_EDIT_POLICY -> "You do not have permission to edit the '" + namespace + "' namespace";
			};
		}
	}

	public boolean canViewerEdit(User user, Supplier<Optional<NamespaceEditPolicy>> editPolicy) {
		return user != null && authorityTiers.authenticated(user) && !authorityTiers.isReadOnly(user)
				&& editableUnder(editPolicy.get(), user);
	}

	public Optional<NamespaceEditDenial> namespaceEditDenial(String namespace, User user,
			Optional<NamespaceEditPolicy> editPolicy) {
		if (editableUnder(editPolicy, user))
			return Optional.empty();
		if (editPolicy.map(NamespaceEditPolicy::systemManaged).orElse(false))
			return Optional.of(new NamespaceEditDenial(NamespaceEditDenialReason.SYSTEM_MANAGED, namespace,
					Optional.empty()));
		return Optional.of(requiredPermissionCode(editPolicy)
				.map(code -> new NamespaceEditDenial(NamespaceEditDenialReason.MISSING_PERMISSION, namespace,
						Optional.of(code)))
				.orElseGet(() -> new NamespaceEditDenial(NamespaceEditDenialReason.NO_EDIT_POLICY, namespace,
						Optional.empty())));
	}

	private boolean editableUnder(Optional<NamespaceEditPolicy> editPolicy, User user) {
		if (editPolicy.isEmpty() || editPolicy.get().systemManaged())
			return false;
		Optional<String> required = requiredPermissionCode(editPolicy);
		if (required.isEmpty())
			return true;
		return user != null && authorityTiers.hasRole(user, "ROLE_" + required.get());
	}

	private static Optional<String> requiredPermissionCode(Optional<NamespaceEditPolicy> editPolicy) {
		return editPolicy.flatMap(NamespaceEditPolicy::editPermissionCode)
				.map(String::trim)
				.filter(code -> !code.isEmpty());
	}
}
