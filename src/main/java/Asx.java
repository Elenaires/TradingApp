import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Asx extends Exchange {

    @Override
    public BigDecimal getCharge() {
        return new BigDecimal("7");
    }
}
