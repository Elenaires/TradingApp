/*
 *   Class name: InsufficientUnitsException
 *   PURPOSE: Custom exception to handle attempts to buy stock when insufficient volume is available
 */

package exceptions;

public class InsufficientUnitsException extends Exception{
    public InsufficientUnitsException(String message) {
        super(message);
    }
}
