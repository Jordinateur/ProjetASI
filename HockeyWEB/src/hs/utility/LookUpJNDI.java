package hs.utility;

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
	public static GardienManagerRemote lookupManager() throws NamingException{
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

}
