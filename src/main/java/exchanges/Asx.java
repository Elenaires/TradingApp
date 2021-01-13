/*
 *  Class name : Asx
 *  PURPOSE: Concrete class of Exchange
 */

package exchanges;

import utils.IO;
import java.math.BigDecimal;

public class Asx extends Exchange {

    private BigDecimal charge = new BigDecimal("0.07");

    public Asx(IO io) {
        super(io);
    }

    @Override
    public BigDecimal getCharge() {
        return charge;
    }

    @Override
    protected String getExchangeName() {
        return "ASX";
    }
}
