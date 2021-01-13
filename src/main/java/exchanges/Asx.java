/*
 *  Class name : Asx
 *  PURPOSE: Concrete class of Exchange
 */

package exchanges;

import utils.IO;
import java.math.BigDecimal;

public class Asx extends Exchange {

    public Asx(IO io) {
        super(io);
    }

    @Override
    public BigDecimal getCharge() {
        return new BigDecimal("7");
    }

    @Override
    protected String getExchangeName() {
        return "ASX";
    }
}
