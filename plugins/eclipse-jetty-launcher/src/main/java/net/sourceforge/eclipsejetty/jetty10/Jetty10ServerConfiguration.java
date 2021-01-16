package net.sourceforge.eclipsejetty.jetty10;

import net.sourceforge.eclipsejetty.jetty.JettyConfigBuilder;
import net.sourceforge.eclipsejetty.jetty9.Jetty9ServerConfiguration;
import net.sourceforge.eclipsejetty.util.DOMBuilder;

public class Jetty10ServerConfiguration extends Jetty9ServerConfiguration {

    @Override
	protected void buildBody(DOMBuilder domBuilder) {
		super.buildBody(domBuilder);
		
		domBuilder.setDTDUrl("https://www.eclipse.org/jetty/configure_10_0.dtd");
	}

	/**
	 * Override the https configuration from Jetty 9.  In Jetty 10 the configuration has been moved
	 * to an internal class, org.eclipse.jetty.util.ssl.SslContextFactory$Server.
	 * 
     * {@inheritDoc}
     * 
     * @see net.sourceforge.eclipsejetty.jetty7.Jetty7ServerConfiguration#buildHttpsConfig(net.sourceforge.eclipsejetty.jetty.JettyConfigBuilder)
     */
    @Override
    protected void buildHttpsConfig(JettyConfigBuilder builder)
    {
        if (getSslPort() == null)
        {
            return;
        }

        builder.comment("HTTPs Config");

        builder.beginNew("sslContextFactory", "org.eclipse.jetty.util.ssl.SslContextFactory$Server");
        {
            builder.set("KeyStorePath", getKeyStorePath());
            builder.set("KeyStorePassword", getKeyStorePassword());
            builder.set("KeyManagerPassword", getKeyManagerPassword());
            builder.set("TrustStorePath", getKeyStorePath());
            builder.set("TrustStorePassword", getKeyStorePassword());
            builder.set("EndpointIdentificationAlgorithm", "");
            builder.setArray("ExcludeCipherSuites", //
                "SSL_RSA_WITH_DES_CBC_SHA", //
                "SSL_DHE_RSA_WITH_DES_CBC_SHA", //
                "SSL_DHE_DSS_WITH_DES_CBC_SHA", //
                "SSL_RSA_EXPORT_WITH_RC4_40_MD5", //
                "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", //
                "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", //
                "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        }
        builder.end();

        builder.beginNew("sslHttpConfig", "org.eclipse.jetty.server.HttpConfiguration");
        {
            builder.argRef("httpConfig");
            builder.beginCall("addCustomizer");
            {
                builder.beginArg();
                {
                    builder.beginNew("org.eclipse.jetty.server.SecureRequestCustomizer").end();
                }
                builder.end();
            }
            builder.end();
        }
        builder.end();
    }

    /**
	 * Override the https configuration from Jetty 9.  In Jetty 10 the configuration of the 
	 * default server has been moved to the Configurations class.
     */
	@Override
	protected void buildAnnotations(JettyConfigBuilder builder) {
        if (!isAnnotationsEnabled())
        {
            return;
        }

        builder.comment("Annotations");

        builder.beginCall(null, "org.eclipse.jetty.webapp.Configurations", "setServerDefault");
        {
            builder.argRef("Server");
//            builder.beginCall("addBefore");
//            {
//                builder.arg("addBefore", "org.eclipse.jetty.webapp.JettyWebXmlConfiguration");
//                builder.argArray("org.eclipse.jetty.annotations.AnnotationConfiguration");
//            }
//            builder.end();
        }
        builder.end();
	}
}
