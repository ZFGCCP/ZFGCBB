package com.zfgc.zfgbb.dataprovider;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AbstractDataProvider {

	public <T, U> List<U> convertDboListToModel(List<T> input, Class<U> type) {
		if (input != null) {
			return input.stream().map(x -> map(x, type)).collect(Collectors.toList());
		}

		return new ArrayList<U>();
	}

	protected <U> U map(Object source, Class<U> type) {
		if (source == null)
			return null;
		try {
			U target = type.getDeclaredConstructor().newInstance();
			Map<String, PropertyDescriptor> targetProperties = new HashMap<>();
			for (PropertyDescriptor property : Introspector.getBeanInfo(type).getPropertyDescriptors())
				targetProperties.put(property.getName(), property);
			for (PropertyDescriptor sourceProperty : Introspector.getBeanInfo(source.getClass()).getPropertyDescriptors()) {
				if (sourceProperty.getReadMethod() == null)
					continue;
				PropertyDescriptor targetProperty = targetProperties.get(sourceProperty.getName());
				if (targetProperty == null || targetProperty.getWriteMethod() == null)
					continue;
				boolean assignable = targetProperty.getPropertyType().isAssignableFrom(sourceProperty.getPropertyType());
				boolean stringConvertible = targetProperty.getPropertyType() == String.class;
				if (!assignable && !stringConvertible)
					continue;
				Object value = sourceProperty.getReadMethod().invoke(source);
				if (value == null)
					continue;
				targetProperty.getWriteMethod().invoke(target, assignable ? value : value.toString());
			}
			return target;
		} catch (IntrospectionException | ReflectiveOperationException exception) {
			throw new IllegalStateException("mapping failed: " + source.getClass().getName() + " -> " + type.getName(), exception);
		}
	}
}
