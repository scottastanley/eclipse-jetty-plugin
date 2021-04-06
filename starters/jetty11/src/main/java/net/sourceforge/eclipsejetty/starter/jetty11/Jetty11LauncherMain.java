// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package net.sourceforge.eclipsejetty.starter.jetty11;

import java.io.File;
import java.io.PrintStream;
import java.net.URL;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlConfiguration;

import net.sourceforge.eclipsejetty.starter.common.AbstractJettyLauncherMain;
import net.sourceforge.eclipsejetty.starter.common.ServerAdapter;

/**
 * Main for Jetty 11
 * 
 * @author Scott Stanley
 */
public class Jetty11LauncherMain extends AbstractJettyLauncherMain
{

    /**
     * Calls the {@link #launch(String[])} method
     * 
     * @param args the arguments
     * @throws Exception on occasion
     */
    public static void main(String[] args) throws Exception
    {
        new Jetty11LauncherMain().launch(args);
    }

    /**
     * Logo formatted with http://patorjk.com/software/taag/#p=display&f=Big&t=
     * 
     * {@inheritDoc}
     * 
     * @see net.sourceforge.eclipsejetty.starter.common.AbstractJettyLauncherMain#printLogo(java.io.PrintStream)
     */
    @Override
    protected void printLogo(PrintStream out)
    {
        out.println(" ______     _ _                       _      _   _           __ __ ");
        out.println("|  ____|   | (_)                     | |    | | | |         /_ /_ |");
        out.println("| |__   ___| |_ _ __  ___  ___       | | ___| |_| |_ _   _   | || |");
        out.println("|  __| / __| | | '_ \\/ __|/ _ \\  _   | |/ _ \\ __| __| | | |  | || |");
        out.println("| |___| (__| | | |_) \\__ \\  __/ | |__| |  __/ |_| |_| |_| |  | || |");
        out.println("|______\\___|_|_| .__/|___/\\___|  \\____/ \\___|\\__|\\__|\\__, |  |_||_|");
        out.println("               | |                                    __/ |        ");
        out.println("               |_|                                   |___/         ");
    }

    /**
     * {@inheritDoc}
     * 
     * @see net.sourceforge.eclipsejetty.starter.common.AbstractJettyLauncherMain#createAdapter(java.io.File[], boolean)
     */
    @Override
    protected ServerAdapter createAdapter(File[] configurationFiles, boolean showInfo) throws Exception
    {
        return new Jetty11Adapter(new Server());
    }

    /**
     * {@inheritDoc}
     * 
     * @see net.sourceforge.eclipsejetty.starter.common.AbstractJettyLauncherMain#configure(java.io.FileInputStream,
     *      java.lang.Class, net.sourceforge.eclipsejetty.starter.common.ServerAdapter)
     */
    @Override
    protected void configure(URL inUrl, Class<?> type, ServerAdapter adapter) throws Exception
    {
        Server server = (Server) adapter.getServer();
        Resource resource = Resource.newResource(inUrl);
        XmlConfiguration configuration = new XmlConfiguration(resource);

        if (type.isInstance(server))
        {
            configuration.configure(server);

            return;
        }

        boolean success = false;

        for (Handler handler : server.getHandlers())
        {
            if (type.isInstance(handler))
            {
                configuration.configure(handler);

                success = true;
            }
        }

        if (success)
        {
            return;
        }

        throw new IllegalArgumentException(String.format(
            "Failed to run configuration for %s. No matching object found in server.", type));
    }
}
