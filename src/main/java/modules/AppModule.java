package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import exchanges.StockExchange;


public class AppModule extends AbstractModule {

    final String exchange;

    public AppModule(String exchange) {
        this.exchange = exchange;
    }

    @Override
    protected void configure() {
        bind(StockExchange.class).toProvider(new ExchangeProvider(exchange));
    }

    /*@Provides
    public exchanges.Exchange provideExchange() {
        System.out.println("provideExchange:" + exchange);
        exchanges.Exchange ex = null;
        switch(exchange) {
            case "ASX":
                ex = new exchanges.Asx();
                break;
            case "CXA":
                ex = new exchanges.Cxa();
                break;
        }
        return ex;
    }*/
}
