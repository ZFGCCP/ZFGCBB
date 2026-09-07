package com.zfgc.zfgbb.mbg;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;

public class MapperRootInterfacePlugin extends PluginAdapter {

	private static final String READ_MAPPER = "com.zfgc.zfgbb.persistence.ReadMapper";
	private static final String CRUD_MAPPER = "com.zfgc.zfgbb.persistence.CrudMapper";
	private static final String IDENTITY_CRUD_MAPPER = "com.zfgc.zfgbb.persistence.IdentityCrudMapper";
	private static final String VERSIONED_IDENTITY_CRUD_MAPPER =
			"com.zfgc.zfgbb.persistence.VersionedIdentityCrudMapper";

	private static final Set<String> ROOT_DECLARED_METHOD_NAMES = Set.of(
			"countByExample", "selectByExample", "selectByExampleWithLimits", "selectByPrimaryKey",
			"insert", "insertSelective", "updateByPrimaryKey", "updateByPrimaryKeySelective",
			"updateByExample", "updateByExampleSelective", "deleteByPrimaryKey", "deleteByExample",
			VersionedUpdatePlugin.METHOD_NAME, SelectForUpdatePlugin.METHOD_NAME);

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean clientGenerated(@NonNull Interface interfaze, @NonNull IntrospectedTable introspectedTable) {
		List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
		if (primaryKeyColumns.size() > 1)
			throw new IllegalStateException(introspectedTable.getFullyQualifiedTableNameAtRuntime()
					+ " has a composite primary key, which the mapper root interfaces and AbstractDbo.getPkId"
					+ " do not model. Give it a single-column key or exclude it from generatorConfig.xml.");

		FullyQualifiedJavaType dbo = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		FullyQualifiedJavaType example = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		Optional<FullyQualifiedJavaType> primaryKey = primaryKeyColumns.stream()
				.findFirst()
				.map(IntrospectedColumn::getFullyQualifiedJavaType);

		FullyQualifiedJavaType rootInterface = new FullyQualifiedJavaType(rootInterfaceName(introspectedTable));
		rootInterface.addTypeArgument(dbo);
		rootInterface.addTypeArgument(example);
		primaryKey.ifPresent(rootInterface::addTypeArgument);

		interfaze.getMethods().removeIf(method -> ROOT_DECLARED_METHOD_NAMES.contains(method.getName()));

		interfaze.getImportedTypes().clear();
		interfaze.addSuperInterface(rootInterface);
		interfaze.addImportedType(rootInterface);
		interfaze.addImportedType(dbo);
		interfaze.addImportedType(example);
		primaryKey.ifPresent(interfaze::addImportedType);
		return true;
	}

	private String rootInterfaceName(IntrospectedTable introspectedTable) {
		if (!introspectedTable.hasPrimaryKeyColumns())
			return READ_MAPPER;
		if (introspectedTable.getGeneratedKey().isEmpty())
			return CRUD_MAPPER;
		if (VersionedUpdatePlugin.versionColumnOf(introspectedTable).isPresent())
			return VERSIONED_IDENTITY_CRUD_MAPPER;
		return IDENTITY_CRUD_MAPPER;
	}
}
