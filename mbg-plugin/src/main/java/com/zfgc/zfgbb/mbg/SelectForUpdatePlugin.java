package com.zfgc.zfgbb.mbg;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.jspecify.annotations.NonNull;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.runtime.mybatis3.MyBatis3FormattingUtilities;

public class SelectForUpdatePlugin extends PluginAdapter {

	static final String METHOD_NAME = "selectByPrimaryKeyForUpdate";

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean clientGenerated(@NonNull Interface interfaze, @NonNull IntrospectedTable introspectedTable) {
		if (!introspectedTable.getRules().generateSelectByPrimaryKey())
			return true;

		Method method = new Method(METHOD_NAME);
		method.setAbstract(true);
		method.setReturnType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
		for (IntrospectedColumn primaryKeyColumn : introspectedTable.getPrimaryKeyColumns())
			method.addParameter(new Parameter(primaryKeyColumn.getFullyQualifiedJavaType(),
					primaryKeyColumn.getJavaProperty()));

		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
		commentGenerator.addGeneralMethodAnnotation(method, introspectedTable, importedTypes);
		interfaze.addImportedTypes(importedTypes);
		interfaze.addMethod(method);
		return true;
	}

	@Override
	public boolean sqlMapDocumentGenerated(@NonNull Document document, @NonNull IntrospectedTable introspectedTable) {
		if (!introspectedTable.getRules().generateSelectByPrimaryKey())
			return true;

		XmlElement select = new XmlElement("select");
		select.addAttribute(new Attribute("id", METHOD_NAME));
		List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
		if (primaryKeyColumns.size() == 1)
			select.addAttribute(new Attribute("parameterType", primaryKeyColumns.get(0)
					.getFullyQualifiedJavaType().getFullyQualifiedName()));
		select.addAttribute(new Attribute("resultMap", introspectedTable.getBaseResultMapId()));
		commentGenerator.addComment(select);

		select.addElement(new TextElement("select "));
		XmlElement columnList = new XmlElement("include");
		columnList.addAttribute(new Attribute("refid", "Base_Column_List"));
		select.addElement(columnList);
		select.addElement(new TextElement("from " + introspectedTable.getFullyQualifiedTableNameAtRuntime()));

		for (int index = 0; index < primaryKeyColumns.size(); index++) {
			IntrospectedColumn column = primaryKeyColumns.get(index);
			select.addElement(new TextElement((index == 0 ? "where " : "  and ")
					+ MyBatis3FormattingUtilities.getEscapedColumnName(column) + " = "
					+ MyBatis3FormattingUtilities.getParameterClause(column)));
		}
		select.addElement(new TextElement("for update"));

		document.getRootElement().addElement(select);
		return true;
	}
}
