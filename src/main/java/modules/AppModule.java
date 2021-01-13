package modules;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import exchanges.StockExchange;


public class AppModule extends AbstractModule {

    final String exchange;

    public AppModule(String exchange) {
        this.exchange = exchange;
    }

    @Override
    protected void configure() {
        bind(StockExchange.class).toProvider(new ExchangeProvider(exchange)).in(Singleton.class);
    }
}
