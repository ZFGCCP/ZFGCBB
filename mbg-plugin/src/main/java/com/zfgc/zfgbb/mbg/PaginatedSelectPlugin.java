package com.zfgc.zfgbb.mbg;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.jspecify.annotations.NonNull;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class PaginatedSelectPlugin extends PluginAdapter {

	private static final String METHOD_NAME = "selectByExampleWithLimits";
	private static final FullyQualifiedJavaType INTEGER_TYPE = new FullyQualifiedJavaType("java.lang.Integer");

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean clientGenerated(@NonNull Interface interfaze, @NonNull IntrospectedTable introspectedTable) {
		FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		FullyQualifiedJavaType modelType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
		returnType.addTypeArgument(modelType);

		Method m = new Method(METHOD_NAME);
		m.setAbstract(true);
		m.setReturnType(returnType);
		m.addParameter(new Parameter(exampleType, "example"));

		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
		commentGenerator.addGeneralMethodAnnotation(m, introspectedTable, importedTypes);
		interfaze.addImportedTypes(importedTypes);

		interfaze.addMethod(m);
		interfaze.addImportedType(exampleType);
		interfaze.addImportedType(modelType);
		interfaze.addImportedType(returnType);
		return true;
	}

	@Override
	public boolean modelExampleClassGenerated(@NonNull TopLevelClass topLevelClass,
			@NonNull IntrospectedTable introspectedTable) {
		topLevelClass.addImportedType(INTEGER_TYPE);
		addPaginationField(topLevelClass, introspectedTable, "limit");
		addPaginationField(topLevelClass, introspectedTable, "offset");
		return true;
	}

	private void addPaginationField(TopLevelClass clazz, IntrospectedTable introspectedTable, String name) {
		Field field = new Field(name, INTEGER_TYPE);
		field.setVisibility(JavaVisibility.PROTECTED);
		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
		commentGenerator.addFieldAnnotation(field, introspectedTable, importedTypes);
		clazz.addImportedTypes(importedTypes);
		clazz.addField(field);

		String suffix = Character.toUpperCase(name.charAt(0)) + name.substring(1);

		Method getter = new Method("get" + suffix);
		getter.setVisibility(JavaVisibility.PUBLIC);
		getter.setReturnType(INTEGER_TYPE);
		getter.addBodyLine("return " + name + ";");
		Set<FullyQualifiedJavaType> getterImportedTypes = new TreeSet<>();
		commentGenerator.addGeneralMethodAnnotation(getter, introspectedTable, getterImportedTypes);
		clazz.addImportedTypes(getterImportedTypes);
		clazz.addMethod(getter);

		Method setter = new Method("set" + suffix);
		setter.setVisibility(JavaVisibility.PUBLIC);
		setter.addParameter(new Parameter(INTEGER_TYPE, name));
		setter.addBodyLine("this." + name + " = " + name + ";");
		Set<FullyQualifiedJavaType> setterImportedTypes = new TreeSet<>();
		commentGenerator.addGeneralMethodAnnotation(setter, introspectedTable, setterImportedTypes);
		clazz.addImportedTypes(setterImportedTypes);
		clazz.addMethod(setter);
	}

	@Override
	public boolean sqlMapDocumentGenerated(@NonNull Document document, @NonNull IntrospectedTable introspectedTable) {
		XmlElement select = new XmlElement("select");
		select.addAttribute(new Attribute("id", METHOD_NAME));
		select.addAttribute(new Attribute("parameterType", introspectedTable.getExampleType()));
		select.addAttribute(new Attribute("resultMap", introspectedTable.getBaseResultMapId()));

		commentGenerator.addComment(select);

		select.addElement(new TextElement("select"));

		XmlElement distinctIf = new XmlElement("if");
		distinctIf.addAttribute(new Attribute("test", "distinct"));
		distinctIf.addElement(new TextElement("distinct"));
		select.addElement(distinctIf);

		XmlElement columnList = new XmlElement("include");
		columnList.addAttribute(new Attribute("refid", "Base_Column_List"));
		select.addElement(columnList);

		select.addElement(new TextElement("from " + introspectedTable.getAliasedFullyQualifiedRuntimeTableName()));

		XmlElement whereIf = new XmlElement("if");
		whereIf.addAttribute(new Attribute("test", "_parameter != null"));
		XmlElement whereInclude = new XmlElement("include");
		whereInclude.addAttribute(new Attribute("refid", "Example_Where_Clause"));
		whereIf.addElement(whereInclude);
		select.addElement(whereIf);

		XmlElement orderByIf = new XmlElement("if");
		orderByIf.addAttribute(new Attribute("test", "orderByClause != null"));
		orderByIf.addElement(new TextElement("order by ${orderByClause}"));
		select.addElement(orderByIf);

		XmlElement limitIf = new XmlElement("if");
		limitIf.addAttribute(new Attribute("test", "limit != null"));
		limitIf.addElement(new TextElement("limit ${limit}"));
		select.addElement(limitIf);

		XmlElement offsetIf = new XmlElement("if");
		offsetIf.addAttribute(new Attribute("test", "offset != null"));
		offsetIf.addElement(new TextElement("offset ${offset}"));
		select.addElement(offsetIf);

		document.getRootElement().addElement(select);
		return true;
	}
}
