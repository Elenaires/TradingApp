import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StockExchange.class).annotatedWith(Imp1.class).to(ASX.class);
        bind(StockExchange.class).annotatedWith(Imp2.class).to(CXA.class);
    }
}
