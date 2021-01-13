import com.google.inject.Provider;

public class ExchangeProvider implements Provider<StockExchange> {

    private final String name;

    public ExchangeProvider(String name) {
        this.name = name;
    }

    @Override
    public StockExchange get() {
        StockExchange ex = null;

        switch(name) {
            case "ASX":
                ex = new Asx();
                break;
            case "CXA":
                ex = new Cxa();
        }

        return ex;
    }
}
