/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.csv_entities;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.onebusaway.csv_entities.exceptions.CsvEntityIOException;
import org.onebusaway.csv_entities.schema.DefaultEntitySchemaFactory;
import org.onebusaway.csv_entities.schema.EntitySchema;
import org.onebusaway.csv_entities.schema.EntitySchemaFactory;

public class CsvEntityWriter implements EntityHandler {

  private File _outputLocation;

  private EntitySchemaFactory _entitySchemaFactory = new DefaultEntitySchemaFactory();

  private CsvEntityContext _context = new CsvEntityContextImpl();

  private Map<Class<?>, IndividualCsvEntityWriter> _writersByType = new HashMap<Class<?>, IndividualCsvEntityWriter>();

  public EntitySchemaFactory getEntitySchemaFactory() {
    return _entitySchemaFactory;
  }

  public void setEntitySchemaFactory(EntitySchemaFactory entitySchemaFactory) {
    _entitySchemaFactory = entitySchemaFactory;
  }

  public void setOutputLocation(File path) {
    _outputLocation = path;
  }

  public void handleEntity(Object entity) {
    Class<?> entityType = entity.getClass();
    IndividualCsvEntityWriter writer = getEntityWriter(entityType);
    writer.handleEntity(entity);
  }

  public void flush() {
    for (IndividualCsvEntityWriter writer : _writersByType.values())
      writer.flush();
  }

  public void close() {
    for (IndividualCsvEntityWriter writer : _writersByType.values())
      writer.close();
  }

  private IndividualCsvEntityWriter getEntityWriter(Class<?> entityType) {

    IndividualCsvEntityWriter entityWriter = _writersByType.get(entityType);
    if (entityWriter == null) {
      EntitySchema schema = _entitySchemaFactory.getSchema(entityType);
      File outputFile = new File(_outputLocation, schema.getFilename());

      if (!_outputLocation.exists())
        _outputLocation.mkdirs();

      PrintWriter writer = openOutput(outputFile, entityType);
      entityWriter = new IndividualCsvEntityWriter(_context, schema, writer);
      _writersByType.put(entityType, entityWriter);
    }
    return entityWriter;
  }

  private PrintWriter openOutput(File outputFile, Class<?> entityType) {
    try {
      return new PrintWriter(outputFile, "UTF-8");
    } catch (IOException ex) {
      throw new CsvEntityIOException(entityType, outputFile.getAbsolutePath(),
          0, ex);
    }
  }
}
