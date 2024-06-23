package jp.example.app;

import java.io.File;
import java.net.URL;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceRoot.ResourceSetType;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;

public class Main {
    private static final String LOCAL_WEBAPP_DIR = "src/main/webapp";
    private static final String CONTEXT_PATH = "";

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.getHost().setAppBase(".");
        tomcat.setPort(8080);
        tomcat.getConnector();

        File webappDir = new File(LOCAL_WEBAPP_DIR);
        Context ctx = webappDir.exists() ? tomcat.addWebapp(CONTEXT_PATH, webappDir.getAbsolutePath())
                : tomcat.addWebapp(CONTEXT_PATH, ".");

        URL url = Main.class.getProtectionDomain().getCodeSource().getLocation();
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.createWebResourceSet(ResourceSetType.PRE, "/WEB-INF/classes", url, "/");
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}
