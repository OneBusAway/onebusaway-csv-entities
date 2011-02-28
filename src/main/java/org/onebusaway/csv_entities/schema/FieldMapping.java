package org.onebusaway.csv_entities.schema;

import java.util.Collection;
import java.util.Map;

import org.onebusaway.csv_entities.CsvEntityContext;
import org.onebusaway.csv_entities.exceptions.CsvEntityException;

public interface FieldMapping {

  public int getOrder();

  public void setOrder(int order);

  public void getCSVFieldNames(Collection<String> names);

  public void translateFromCSVToObject(CsvEntityContext context,
      Map<String, Object> csvValues, BeanWrapper object) throws CsvEntityException;

  public void translateFromObjectToCSV(CsvEntityContext context,
      BeanWrapper object, Map<String, Object> csvValues) throws CsvEntityException;
}
