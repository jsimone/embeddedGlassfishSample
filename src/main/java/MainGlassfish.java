

import java.io.File;

import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;

public class MainGlassfish {
    
    public static void main(String[] args) throws Exception{
        String webappDirLocation = "src/main/webapp/";
        
        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        /** Create and start GlassFish which listens at 8080 http port */
        GlassFishProperties gfProps = new GlassFishProperties();
        gfProps.setPort("http-listener", Integer.valueOf(webPort)); // refer JavaDocs for the details of this API.

        GlassFish glassfish = GlassFishRuntime.bootstrap().newGlassFish(gfProps);
        glassfish.start(); 
        
        Deployer deployer = glassfish.getDeployer();

        // Create a scattered web application.
        ScatteredArchive archive = new ScatteredArchive("myApp", ScatteredArchive.Type.WAR, new File(webappDirLocation));
        // target/classes directory contains my complied servlets
        archive.addClassPath(new File("target", "classes"));

        deployer.deploy(archive.toURI());
        
    }

}
