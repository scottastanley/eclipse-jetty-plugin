package net.sourceforge.eclipsejetty.jetty10;

import java.util.Collection;

import net.sourceforge.eclipsejetty.jetty9.Jetty94LibStrategy;

/**
 * Resolve libs for Jetty 10.0.x
 * 
 * @author Scott Stanley
 */
public class Jetty10LibStrategy extends Jetty94LibStrategy {

	@Override
	protected void addServerDependencies(Collection<String> dependencies) {
        dependencies.add(".*/jetty-servlet-api-.*\\.jar");
        dependencies.add(".*/jetty-http-.*\\.jar");
        dependencies.add(".*/jetty-server-.*\\.jar");
        dependencies.add(".*/jetty-xml-.*\\.jar");
        dependencies.add(".*/jetty-util-.*\\.jar");
        dependencies.add(".*/jetty-io-.*\\.jar");
        dependencies.add(".*/jetty-security-.*\\.jar");
        dependencies.add(".*/jetty-servlet-.*\\.jar");
        dependencies.add(".*/jetty-webapp-.*\\.jar");
        dependencies.add(".*/jetty-deploy-.*\\.jar");
        dependencies.add(".*/jetty-plus-.*\\.jar");
        dependencies.add(".*/jetty-jndi-.*\\.jar");
        dependencies.add(".*/logging/slf4j-api-.*\\.jar");
        dependencies.add(".*/logging/jetty-slf4j-impl-.*\\.jar");
	}

    @Override
    protected void addJSPDependencies(Collection<String> dependencies)
    {
        dependencies.add(".*/apache-jsp\\/.*\\.jar");
        dependencies.add(".*/apache-jstl\\/.*\\.jar");
    }

    @Override
    protected void addJMXDependencies(Collection<String> dependencies)
    {
        dependencies.add(".*/jetty-jmx-.*\\.jar");
    }

    @Override
    protected void addJNDIDependencies(Collection<String> dependencies)
    {
        dependencies.add(".*/jetty-jndi-.*\\.jar");
        dependencies.add(".*/jakarta.transaction-api-.*\\.jar");
        dependencies.add(".*/jetty-plus-.*\\.jar");
    }

    @Override
    protected void addAnnotationsDependencies(Collection<String> dependencies)
    {
        dependencies.add(".*/jetty-annotations-.*\\.jar");
        dependencies.add(".*/annotations/.*\\.jar");
    }

    @Override
    protected void addWebsocketSupport(Collection<String> dependencies)
    {
        dependencies.add(".*/jetty-client-.*\\.jar");
        dependencies.add(".*/websocket/.*\\.jar");
    }

}
