package exchanges;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cxa extends Exchange {

    @Override
    public BigDecimal getCharge() {
        return new BigDecimal("7");
    }
}
