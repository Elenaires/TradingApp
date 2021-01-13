package utils;

import java.math.BigDecimal;
import java.util.Map;

public interface IO {
    BigDecimal readFile(String file, Map<String, Integer> stocks);
    void writeFile(String outString, String fileName, boolean append);
}
