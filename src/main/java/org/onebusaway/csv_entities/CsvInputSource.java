package org.onebusaway.csv_entities;

import java.io.IOException;
import java.io.InputStream;

public interface CsvInputSource {
  public boolean hasResource(String name) throws IOException;
  public InputStream getResource(String name) throws IOException;
  public void close() throws IOException;
}
