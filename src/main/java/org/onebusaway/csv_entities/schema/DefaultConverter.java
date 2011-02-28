package org.onebusaway.csv_entities.schema;

import org.apache.commons.beanutils.Converter;

public class DefaultConverter implements Converter {

  @Override
  public Object convert(@SuppressWarnings("rawtypes") Class type, Object value) {
    if (value == null)
      return "";
    return value.toString();
  }
}
