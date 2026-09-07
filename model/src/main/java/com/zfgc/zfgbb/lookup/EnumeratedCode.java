package com.zfgc.zfgbb.lookup;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public interface EnumeratedCode {

	static <E extends Enum<E>> Optional<E> matchingExactly(Class<E> enumeration, String code) {
		if (code == null)
			return Optional.empty();
		for (E candidate : enumeration.getEnumConstants())
			if (candidate.name().equals(code))
				return Optional.of(candidate);
		return Optional.empty();
	}

	static <E extends Enum<E>> Optional<E> matchingIgnoringCaseAndSurroundingSpace(Class<E> enumeration, String code) {
		return code == null
				? Optional.empty()
				: matchingExactly(enumeration, code.trim().toUpperCase(Locale.ROOT));
	}

	static <E extends Enum<E>> String everyCodeOf(Class<E> enumeration) {
		return Arrays.stream(enumeration.getEnumConstants()).map(Enum::name).collect(Collectors.joining(", "));
	}
}
