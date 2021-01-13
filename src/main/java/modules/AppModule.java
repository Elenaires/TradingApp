/*
*   Class name: AppModule
*   PURPOSE: Bind IO class to its implementation
 */

package modules;

import com.google.inject.AbstractModule;
import utils.FileIO;
import utils.IO;


public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IO.class).to(FileIO.class);
   }
}
