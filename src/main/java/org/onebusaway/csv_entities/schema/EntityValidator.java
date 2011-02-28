package org.onebusaway.csv_entities.schema;

import java.util.Map;

import org.onebusaway.csv_entities.CsvEntityContext;

public interface EntityValidator {

  public int getOrder();

  public void setOrder(int order);

  public void validateEntity(CsvEntityContext context, Map<String, Object> csvValues, BeanWrapper object);

  public void validateCSV(CsvEntityContext context, BeanWrapper object, Map<String, Object> csvValues);
}
