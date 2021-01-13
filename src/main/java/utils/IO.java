/*
 *   Class name: IO
 *   PURPOSE: Interface containing behaviors of input output
 */

package utils;

import java.math.BigDecimal;
import java.util.Map;

public interface IO {

    /* Read from file and populate stocks map */
    BigDecimal readFile(String file, Map<String, Integer> stocks);

    /* Write to file */
    void writeFile(String outString, String fileName, boolean append);
}
