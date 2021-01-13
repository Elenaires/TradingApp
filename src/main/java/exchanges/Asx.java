package exchanges;
import java.math.BigDecimal;

public class Asx extends Exchange {

    @Override
    public BigDecimal getCharge() {
        return new BigDecimal("7");
    }

    @Override
    protected String getExchangeName() {
        return "ASX";
    }
}
