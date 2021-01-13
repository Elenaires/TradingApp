/*
 *   Class name: Stock
 *   PURPOSE: An enumeration of stock types
 */

package enums;

import java.util.Random;

public enum Stock {
    NAB("NAB"),
    CBA("CBA"),
    QAN("QAN");

    private String name;

    private Stock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Stock getRandomStock() {
        return Stock.values()[new Random().nextInt(Stock.values().length)];
    }
}
