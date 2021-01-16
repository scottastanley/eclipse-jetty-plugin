package net.sourceforge.eclipsejetty.jetty10;

import java.util.Collection;

import net.sourceforge.eclipsejetty.jetty9.Jetty94LibStrategy;

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

}
