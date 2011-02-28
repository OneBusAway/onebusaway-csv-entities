package org.onebusaway.csv_entities.schema;

import org.onebusaway.csv_entities.schema.beans.CsvEntityMappingBean;

import java.util.Collection;

public interface ListableCsvMappingFactory {
  public Collection<CsvEntityMappingBean> getEntityMappings();
}
