/*
 *   Class name: InvalidCodeException
 *   PURPOSE: Custom exception to handle attempts to buy/sell stock with invalid stock code
 */

package exceptions;

public class InvalidCodeException extends Exception{
    public InvalidCodeException(String message) {
        super(message);
    }
}
