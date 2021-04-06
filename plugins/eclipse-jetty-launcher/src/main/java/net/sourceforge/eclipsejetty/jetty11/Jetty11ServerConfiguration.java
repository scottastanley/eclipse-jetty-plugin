package net.sourceforge.eclipsejetty.jetty11;

import net.sourceforge.eclipsejetty.jetty10.Jetty10ServerConfiguration;

/**
 * Server configuration for Jetty 11
 * 
 * Jetty 11 is the same as Jetty 10.  Only difference is the shift to the
 * jakarta.* packages versus javax.*.
 * 
 * @author Scott Stanley
 */
public class Jetty11ServerConfiguration extends Jetty10ServerConfiguration {
    
    @Override
    protected String getDTD() {
        return "https://www.eclipse.org/jetty/configure_11_0.dtd";
    }
}
