package exchanges;

import utils.IO;

import java.math.BigDecimal;

public class Cxa extends Exchange {

    public Cxa(IO io) {
        super(io);
    }

    @Override
    public BigDecimal getCharge() {
        return new BigDecimal("7");
    }

    @Override
    protected String getExchangeName() {
        return "CXA";
    }
}
