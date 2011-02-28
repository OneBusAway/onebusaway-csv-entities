package org.onebusaway.csv_entities.schema;

public interface EntityValidatorFactory {
  public EntityValidator createEntityValidator(EntitySchemaFactory schemaFactory);
}
