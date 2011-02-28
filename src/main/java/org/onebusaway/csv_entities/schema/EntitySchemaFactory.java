package org.onebusaway.csv_entities.schema;

public interface EntitySchemaFactory {

  public EntitySchema getSchema(Class<?> entityClass);

}