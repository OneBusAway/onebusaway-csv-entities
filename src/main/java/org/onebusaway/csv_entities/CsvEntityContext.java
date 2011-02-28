package org.onebusaway.csv_entities;

public interface CsvEntityContext {

  public Object put(Object key, Object value);

  public Object get(Object key);
}
