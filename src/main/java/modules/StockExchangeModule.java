package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import exchanges.StockExchange;

public class StockExchangeModule extends AbstractModule {
    private String exchangeName;

    public StockExchangeModule(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    @Override
    protected void configure() {
        bind(StockExchange.class).toProvider(new ExchangeProvider(exchangeName)).in(Singleton.class);
    }


}
