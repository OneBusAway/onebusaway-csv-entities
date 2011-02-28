package org.onebusaway.csv_entities.exceptions;

import org.onebusaway.csv_entities.schema.AnnotationDrivenEntitySchemaFactory;
import org.onebusaway.csv_entities.schema.annotations.CsvFields;

/**
 * Indicates that an entity type was passed to
 * {@link AnnotationDrivenEntitySchemaFactory} for introspection and the
 * specified entity type did not have a {@link CsvFields} class annotation
 * 
 * @author bdferris
 * @see CsvFields
 * @see AnnotationDrivenEntitySchemaFactory
 */
public class NoCsvFieldsAnnotationException extends CsvEntityException {

  private static final long serialVersionUID = 1L;

  public NoCsvFieldsAnnotationException(Class<?> entityType) {
    super(entityType, "No @CsvFields annotation found for entity type "
        + entityType.getName());
  }
}
