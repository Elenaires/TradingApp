package utils;

import java.util.Map;

public interface IO {
    void readFile(String file, Map<String, Integer> stocks);
    void writeFile(String outString, String fileName);
}
