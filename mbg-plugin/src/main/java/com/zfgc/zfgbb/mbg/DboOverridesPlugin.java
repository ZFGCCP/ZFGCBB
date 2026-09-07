package com.zfgc.zfgbb.mbg;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class DboOverridesPlugin extends PluginAdapter {

	private static final FullyQualifiedJavaType INTEGER = new FullyQualifiedJavaType("java.lang.Integer");
	private static final FullyQualifiedJavaType OFFSET_DATE_TIME = new FullyQualifiedJavaType(
			"java.time.OffsetDateTime");
	private static final FullyQualifiedJavaType ABSTRACT_DBO = new FullyQualifiedJavaType(
			"com.zfgc.zfgbb.dbo.AbstractDbo");

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		topLevelClass.setSuperClass(ABSTRACT_DBO);
		topLevelClass.addMethod(buildPkIdOverride(introspectedTable, topLevelClass));
		topLevelClass.addImportedType(OFFSET_DATE_TIME);
		topLevelClass.addMethod(
				buildTimestampOverride(introspectedTable, topLevelClass, "created_ts", "getCreatedTime", "createdTs"));
		topLevelClass.addMethod(
				buildTimestampOverride(introspectedTable, topLevelClass, "updated_ts", "getUpdatedTime", "updatedTs"));
		return true;
	}

	private Method buildPkIdOverride(IntrospectedTable table, TopLevelClass topLevelClass) {
		Method m = new Method("getPkId");
		m.setVisibility(JavaVisibility.PUBLIC);
		m.setReturnType(INTEGER);
		m.addAnnotation("@Override");
		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
		commentGenerator.addGeneralMethodAnnotation(m, table, importedTypes);
		topLevelClass.addImportedTypes(importedTypes);

		List<IntrospectedColumn> pks = table.getPrimaryKeyColumns();
		if (pks.isEmpty()) {
			m.addBodyLine("return null;");
		} else {
			IntrospectedColumn pk = pks.get(0);
			String pkJavaType = pk.getFullyQualifiedJavaType().getFullyQualifiedName();
			if (java.lang.Integer.class.getName().equals(pkJavaType)) {
				m.addBodyLine("return " + pk.getJavaProperty() + ";");
			} else {
				m.addBodyLine("return null;");
			}
		}
		return m;
	}

	private Method buildTimestampOverride(IntrospectedTable table, TopLevelClass topLevelClass, String columnName,
			String methodName,
			String fieldName) {
		Method m = new Method(methodName);
		m.setVisibility(JavaVisibility.PUBLIC);
		m.setReturnType(OFFSET_DATE_TIME);
		m.addAnnotation("@Override");
		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
		commentGenerator.addGeneralMethodAnnotation(m, table, importedTypes);
		topLevelClass.addImportedTypes(importedTypes);

		boolean hasColumn = table.getAllColumns().stream()
				.anyMatch(c -> columnName.equalsIgnoreCase(c.getActualColumnName()));
		if (hasColumn) {
			m.addBodyLine("return " + fieldName + ";");
		} else {
			m.addBodyLine("return null;");
		}
		return m;
	}
}
