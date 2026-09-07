package com.zfgc.zfgbb.mbg;

import java.util.List;

import org.jspecify.annotations.NonNull;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * Uses PostgreSQL's case-insensitive pattern operator for generated String
 * {@code Like} and {@code NotLike} example criteria.
 */
public class PostgresqlIlikePlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean modelExampleClassGenerated(@NonNull TopLevelClass topLevelClass,
			@NonNull IntrospectedTable introspectedTable) {
		for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
			for (Method method : innerClass.getMethods()) {
				if (isStringLikeCriterion(method)) {
					List<String> lines = method.getBodyLines();
					for (int i = 0; i < lines.size(); i++) {
						lines.set(i, lines.get(i)
								.replace(" not like\"", " not ilike\"")
								.replace(" like\"", " ilike\""));
					}
				}
			}
		}
		return true;
	}

	private boolean isStringLikeCriterion(Method method) {
		return (method.getName().endsWith("Like") || method.getName().endsWith("NotLike"))
				&& method.getParameters().size() == 1
				&& "java.lang.String".equals(
						method.getParameters().get(0).getType().getFullyQualifiedName());
	}
}
