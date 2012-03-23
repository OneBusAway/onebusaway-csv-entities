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
package org.onebusaway.csv_entities.schema;

import java.util.ArrayList;
import java.util.List;

public class EntitySchema {

  private String _filename;

  private List<FieldMapping> _fields = new ArrayList<FieldMapping>();

  private List<EntityValidator> _validators = new ArrayList<EntityValidator>();

  private Class<?> _entityClass;

  private boolean _required;

  private List<String> _fieldsInOrder = new ArrayList<String>();

  public EntitySchema(Class<?> entityClass, String filename, boolean required) {
    _entityClass = entityClass;
    _filename = filename;
    _required = required;
  }

  public EntitySchema(EntitySchema schema) {
    _filename = schema._filename;
    _fields.addAll(schema._fields);
    _validators.addAll(schema._validators);
    _entityClass = schema._entityClass;
    _required = schema._required;
    _fieldsInOrder.addAll(schema._fieldsInOrder);
  }

  public void addField(FieldMapping field) {
    _fields.add(field);
  }

  public void addValidator(EntityValidator entityValidator) {
    _validators.add(entityValidator);
  }

  public Class<?> getEntityClass() {
    return _entityClass;
  }

  public String getFilename() {
    return _filename;
  }

  public boolean isRequired() {
    return _required;
  }

  public List<FieldMapping> getFields() {
    return _fields;
  }

  public List<EntityValidator> getValidators() {
    return _validators;
  }

  public void setFieldsInOrder(List<String> fieldsInOrder) {
    _fieldsInOrder = fieldsInOrder;
  }

  public List<String> getFieldsInOrder() {
    return _fieldsInOrder;
  }
}
