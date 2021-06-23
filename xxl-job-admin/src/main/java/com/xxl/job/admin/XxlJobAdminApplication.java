package com.xxl.job.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//add dep
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.net.InetAddress;

import org.springframework.core.env.Environment;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */

@SpringBootApplication

public class XxlJobAdminApplication {

    //	public static void main(String[] args) {
//        SpringApplication.run(XxlJobAdminApplication.class, args);
//	}
    private static Logger logger = LoggerFactory.getLogger(XxlJobAdminApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        Environment env = new SpringApplication(XxlJobAdminApplication.class).run(args).getEnvironment();
        String envPort = env.getProperty("server.port");
        String envContext = env.getProperty("server.servlet.context-path");
        String context = envContext == null ? "" : envContext;
        String path = envPort + "" + context;
        String externalAPI = InetAddress.getLocalHost().getHostAddress();
        logger.info(
                "Access URLs:\n----------------------------------------------------------\n\t"
                        + "External-URL: \thttp://{}:{}\n\t"
                        + "web-URL: \thttp://127.0.0.1:{}\n\t----------------------------------------------------------",
                externalAPI, path, path);
    }
}