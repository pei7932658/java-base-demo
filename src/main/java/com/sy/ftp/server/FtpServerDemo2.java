package com.sy.ftp.server;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 基于apache ftpserver http://mina.apache.org/ftpserver-project/
 */
public class FtpServerDemo2 {
    public static void main(String[] args) throws FtpException {
        FtpServerFactory serverFactory = new FtpServerFactory();


        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();

        userManagerFactory.setFile(new File("src/main/resources/user.properties"));

        serverFactory.setUserManager(userManagerFactory.createUserManager());

        FtpServer server = serverFactory.createServer();
        server.start();
    }
}
