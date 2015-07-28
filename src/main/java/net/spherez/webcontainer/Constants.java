package net.spherez.webcontainer;

import java.io.File;

public class Constants {
    protected static final int SERVER_PORT = 5674;
    protected static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    protected static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webapps";
}