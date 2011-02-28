package org.onebusaway.csv_entities;

import java.util.List;

public interface TokenizerStrategy {
  public List<String> parse(String line);
  public String format(Iterable<String> tokens);
}
