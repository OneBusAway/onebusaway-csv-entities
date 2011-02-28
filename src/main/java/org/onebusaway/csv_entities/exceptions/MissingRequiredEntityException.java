package org.onebusaway.csv_entities.exceptions;

import org.onebusaway.csv_entities.schema.EntitySchema;
import org.onebusaway.csv_entities.schema.annotations.CsvFields;
import org.onebusaway.csv_entities.schema.beans.CsvEntityMappingBean;

/**
 * Indicates that the specified entity type is marked as required, but no input
 * file or source was found for that entity.
 * 
 * @author bdferris
 * @see EntitySchema#isRequired()
 * @see CsvFields#required()
 * @see CsvEntityMappingBean#isRequired()
 */
public class MissingRequiredEntityException extends CsvEntityException {

  private static final long serialVersionUID = 1L;

  private String _fileName;

  public MissingRequiredEntityException(Class<?> entityType, String fileName) {
    super(entityType, "missing required entity: type=" + entityType.getName()
        + " filename=" + fileName);
    _fileName = fileName;
  }

  public String getFileName() {
    return _fileName;
  }
}
