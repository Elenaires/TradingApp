/*
 *  Class name : Cxa
 *  PURPOSE: Concrete class of Exchange
 */

package exchanges;

import utils.IO;
import java.math.BigDecimal;

public class Cxa extends Exchange {

    private BigDecimal charge = new BigDecimal("0.05");

    public Cxa(IO io) {
        super(io);
    }

    @Override
    public BigDecimal getCharge() {
        return charge;
    }

    @Override
    protected String getExchangeName() {
        return "CXA";
    }
}
