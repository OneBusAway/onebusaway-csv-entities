/**
 * Copyright (C) 2024 OneBusAway contributors
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
package org.onebusaway.csv_entities.schema.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;

/**
 * This annotation indicates that a field is experimental.
 */
@Retention(value = RetentionPolicy.CLASS)
@Target(value = ElementType.FIELD)
@Documented
public @interface ExperimentalField {
  /**
   * If specified, this indicates what issue this field was proposed in.
   */
  String proposedBy() default "";
}
