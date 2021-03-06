package utilities;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LookupUtility {
	public static Object lookupRemote(String cl,boolean statef) throws NamingException {
    	Object remote=null;
        try {
        	Properties jndiProps = new Properties();
            //jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
            jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProps.setProperty("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
            jndiProps.setProperty(Context.PROVIDER_URL, "remote://localhost:4447");
            jndiProps.put("jboss.naming.client.ejb.context", true);
            jndiProps.put("org.jboss.ejb.client.scoped.context", "true");
            InitialContext ctx = new InitialContext(jndiProps);
            if(statef){
            	remote = ctx.lookup("java:/HockeyEAR/HockeyEJB/" + cl + "!hs.ejb." + cl + "Remote?stateful");
            }else{
            	remote = ctx.lookup("java:/HockeyEAR/HockeyEJB/" + cl + "!hs.ejb." + cl + "Remote");            	
            }
        	} catch (Exception e) {
            e.printStackTrace();
        		}    	
        return remote;
    }
}
