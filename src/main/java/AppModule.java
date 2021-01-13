import com.google.inject.AbstractModule;
import com.google.inject.Provides;

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
    public Exchange provideExchange() {
        System.out.println("provideExchange:" + exchange);
        Exchange ex = null;
        switch(exchange) {
            case "ASX":
                ex = new Asx();
                break;
            case "CXA":
                ex = new Cxa();
                break;
        }
        return ex;
    }*/
}
