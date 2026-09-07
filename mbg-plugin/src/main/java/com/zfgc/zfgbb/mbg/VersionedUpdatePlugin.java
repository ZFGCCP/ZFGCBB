package com.zfgc.zfgbb.mbg;

import java.util.List;
import java.util.Optional;
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

public class VersionedUpdatePlugin extends PluginAdapter {

	static final String METHOD_NAME = "updateByPrimaryKeyAndVersion";

	private static final String VERSION_COLUMN_NAME = "updated_ts";
	private static final FullyQualifiedJavaType INT = new FullyQualifiedJavaType("int");

	static Optional<IntrospectedColumn> versionColumnOf(IntrospectedTable introspectedTable) {
		if (introspectedTable.getPrimaryKeyColumns().size() != 1)
			return Optional.empty();
		if (introspectedTable.getGeneratedKey().isEmpty())
			return Optional.empty();
		return introspectedTable.getAllColumns().stream()
				.filter(column -> VERSION_COLUMN_NAME.equalsIgnoreCase(column.getActualColumnName()))
				.filter(IntrospectedColumn::isGeneratedAlways)
				.findFirst();
	}

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean clientGenerated(@NonNull Interface interfaze, @NonNull IntrospectedTable introspectedTable) {
		if (versionColumnOf(introspectedTable).isEmpty())
			return true;

		Method method = new Method(METHOD_NAME);
		method.setAbstract(true);
		method.setReturnType(INT);
		method.addParameter(new Parameter(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()), "row"));

		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
		commentGenerator.addGeneralMethodAnnotation(method, introspectedTable, importedTypes);
		interfaze.addImportedTypes(importedTypes);
		interfaze.addMethod(method);
		return true;
	}

	@Override
	public boolean sqlMapDocumentGenerated(@NonNull Document document, @NonNull IntrospectedTable introspectedTable) {
		Optional<IntrospectedColumn> versionColumn = versionColumnOf(introspectedTable);
		if (versionColumn.isEmpty())
			return true;

		XmlElement update = new XmlElement("update");
		update.addAttribute(new Attribute("id", METHOD_NAME));
		update.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
		commentGenerator.addComment(update);

		update.addElement(new TextElement("update " + introspectedTable.getFullyQualifiedTableNameAtRuntime()));

		List<IntrospectedColumn> assignable = introspectedTable.getNonPrimaryKeyColumns().stream()
				.filter(column -> !column.isGeneratedAlways())
				.toList();
		for (int index = 0; index < assignable.size(); index++) {
			IntrospectedColumn column = assignable.get(index);
			update.addElement(new TextElement((index == 0 ? "set " : "  ")
					+ MyBatis3FormattingUtilities.getEscapedColumnName(column) + " = "
					+ MyBatis3FormattingUtilities.getParameterClause(column)
					+ (index == assignable.size() - 1 ? "" : ",")));
		}

		IntrospectedColumn primaryKeyColumn = introspectedTable.getPrimaryKeyColumns().get(0);
		update.addElement(new TextElement("where "
				+ MyBatis3FormattingUtilities.getEscapedColumnName(primaryKeyColumn) + " = "
				+ MyBatis3FormattingUtilities.getParameterClause(primaryKeyColumn)));
		update.addElement(new TextElement("  and "
				+ MyBatis3FormattingUtilities.getEscapedColumnName(versionColumn.get()) + " = "
				+ MyBatis3FormattingUtilities.getParameterClause(versionColumn.get())));

		document.getRootElement().addElement(update);
		return true;
	}
}
