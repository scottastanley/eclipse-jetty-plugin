package net.sourceforge.eclipsejetty.jetty11;

import java.util.Collection;

import net.sourceforge.eclipsejetty.jetty10.Jetty10LibStrategy;

/**
 * Resolve libs for Jetty 11.0.x
 * 
 * Jetty 11 is the same as Jetty 10.  Only difference is the shift to the
 * jakarta.* packages versus javax.*.  The jetty-servlet-api jar file has 
 * been removed as part of this and replaced with the 
 * jetty-jakarta-servlet-api jar file.
 * 
 * @author Scott Stanley
 */
public class Jetty11LibStrategy extends Jetty10LibStrategy {

    @Override
    protected void addServerDependencies(Collection<String> dependencies) {
        dependencies.add(".*/jetty-jakarta-servlet-api-.*\\.jar");
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
        dependencies.add(".*/.*-jstl\\/.*\\.jar");
    }
}
