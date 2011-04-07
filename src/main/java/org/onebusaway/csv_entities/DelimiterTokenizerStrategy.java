package org.onebusaway.csv_entities;

import java.util.Arrays;
import java.util.List;

public class DelimiterTokenizerStrategy implements TokenizerStrategy {

  private final String _delimiter;

  public DelimiterTokenizerStrategy(String delimiter) {
    _delimiter = delimiter;
  }

  @Override
  public List<String> parse(String line) {
    return Arrays.asList(line.split(_delimiter));
  }

  @Override
  public String format(Iterable<String> tokens) {
    StringBuilder b = new StringBuilder();
    boolean seenFirst = false;
    for (String token : tokens) {
      if (seenFirst)
        b.append(_delimiter);
      else
        seenFirst = true;
      b.append(token);
    }
    return b.toString();
  }
}
