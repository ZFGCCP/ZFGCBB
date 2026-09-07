package com.zfgc.zfgbb.mbg;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.NonNull;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class ContainsCriterionPlugin extends PluginAdapter {

	private static final String LIKE_PATTERNS = "com.zfgc.zfgbb.persistence.LikePatterns";

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean modelExampleClassGenerated(@NonNull TopLevelClass topLevelClass,
			@NonNull IntrospectedTable introspectedTable) {
		boolean generatedAny = false;
		for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
			List<Method> containsCriteria = new ArrayList<>();
			for (Method method : innerClass.getMethods())
				if (isStringLikeCriterion(method))
					containsCriteria.add(containsCriterion(method, innerClass));
			for (Method containsCriterion : containsCriteria) {
				innerClass.addMethod(containsCriterion);
				generatedAny = true;
			}
		}
		if (generatedAny)
			topLevelClass.addImportedType(new FullyQualifiedJavaType(LIKE_PATTERNS));
		return true;
	}

	private Method containsCriterion(Method likeCriterion, InnerClass owner) {
		Method contains = new Method(
				likeCriterion.getName().substring(0, likeCriterion.getName().length() - "Like".length())
						+ "Contains");
		contains.setVisibility(JavaVisibility.PUBLIC);
		contains.setReturnType(likeCriterion.getReturnType().orElse(null));
		contains.addParameter(new Parameter(new FullyQualifiedJavaType("java.lang.String"), "value"));
		for (String line : likeCriterion.getBodyLines())
			contains.addBodyLine(line.replace(", value,", ", LikePatterns.contains(value),"));
		return contains;
	}

	private boolean isStringLikeCriterion(Method method) {
		return method.getName().endsWith("Like")
				&& !method.getName().endsWith("NotLike")
				&& method.getParameters().size() == 1
				&& "java.lang.String".equals(
						method.getParameters().get(0).getType().getFullyQualifiedName());
	}
}
