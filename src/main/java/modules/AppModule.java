/*
 *   Class name: AppModule
 *   PURPOSE: Bind IO class to its implementation
 */

package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import exchanges.StockExchange;
import utils.FileIO;
import utils.IO;


public class AppModule extends AbstractModule {

    private String exchangeName;

    public AppModule(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    @Override
    protected void configure() {
        bind(StockExchange.class).toProvider(new ExchangeProvider(exchangeName)).in(Singleton.class);
        bind(IO.class).to(FileIO.class);
    }
}
