/*
*   Class name: ExchangeProvider
*   PURPOSE: Contains the logic of implementation selection for StockExchange at runtime
 */

package modules;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import exchanges.Asx;
import exchanges.Cxa;
import exchanges.StockExchange;
import utils.IO;

public class ExchangeProvider implements Provider<StockExchange> {

    private final String name;

    @Inject
    Injector injector;

    public ExchangeProvider(String name) {
        this.name = name;
    }

    @Override
    public StockExchange get() {
        StockExchange ex = null;

        switch(name) {
            case "ASX":
                ex = new Asx(injector.getInstance(IO.class));
                break;
            case "CXA":
                ex = new Cxa(injector.getInstance(IO.class));
        }

        return ex;
    }
}
