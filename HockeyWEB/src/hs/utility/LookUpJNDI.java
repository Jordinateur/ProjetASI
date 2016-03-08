package hs.utility;

import hs.ejb.AbstractManager;
import hs.ejb.AbstractManagerRemote;
import hs.ejb.GardienManagerRemote;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LookUpJNDI {
	
	public static GardienManagerRemote lookupGardienManager() throws NamingException{
		GardienManagerRemote remote=null;
        try {
            Properties jndiProps = new Properties();
            jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            //jndiProps.setProperty(Context.PROVIDER_URL, "jnp://localhost:4447");
            InitialContext ctx = new InitialContext(jndiProps); 
            remote = (GardienManagerRemote) ctx.lookup("java:global/HockeyEAR/HockeyEJB/GardienManager!hs.ejb.GardienManagerRemote");
        	} catch (Exception e) {
        		e.printStackTrace();
        	}    	
        return remote;
	}
	public static Object lookupManager(String className, boolean isStateful) throws NamingException{
		Object remote = null;
		System.out.println(className);
        try {
            Properties jndiProps = new Properties();
            jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            //jndiProps.setProperty(Context.PROVIDER_URL, "jnp://localhost:4447");
            InitialContext ctx = new InitialContext(jndiProps);
            String lookUp = "java:global/HockeyEAR/HockeyEJB/"+className+"!hs.ejb."+className+"Remote";
            lookUp += isStateful ? "?stateful" : "";
            System.out.println(lookUp);
            remote = ctx.lookup(lookUp);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}    	
        return remote;

	}

}
