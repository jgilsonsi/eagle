package com.jjdev.eagle.api.controllers;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author JGilson
 */
@RestController
@RequestMapping("api/v1/log")
@CrossOrigin(origins = "*")
public class JLogController {

    @Value("${log.path}")
    private String logPath;

    private static final Logger log = LoggerFactory.getLogger(JLogController.class);
    private final LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

    public JLogController() {
    }

    /**
     * Update application log level.
     *
     * @param logLevel
     * @param package
     * @return String status of log level
     */
    @PostMapping(value = "/{logLevel}/{packageName:.+}")
    @ApiOperation(value = "updateLogLevel",
            notes = "Log levels can be: ALL, DEBUG, ERROR, INFO, OFF, TRACE and WARN")
    public String updateLogLevel(@PathVariable("logLevel") String logLevel,
            @PathVariable("packageName") String packageName) {

        log.info("Updating log level to {} for package {}", logLevel, packageName);

        return setLogLevel(logLevel, packageName);
    }

    /**
     * Return application log level.
     *
     * @param package
     * @return String log level
     */
    @GetMapping(value = "/{packageName:.+}")
    public String readLogLevel(@PathVariable("packageName") String packageName) {

        String logLevel;
        try {
            logLevel = loggerContext.getLogger(packageName).getLevel().toString();
            log.info("Reading log level of package {}: {}", packageName, logLevel);
        } catch (Exception e) {
            log.error("Invalid package: {}", packageName);
            logLevel = "Invalid package: " + packageName;
        }
        return logLevel;
    }

    /**
     * Return log file to see system outputs.
     *
     * @return log file
     */
    @GetMapping(value = "/file")
    public void readLogFile(HttpServletResponse response) {

        log.info("Searching log file");

        try {
            File logFile = new File(logPath);
            if (logFile.exists()) {
                InputStream in = new FileInputStream(logFile);
                IOUtils.copy(in, response.getOutputStream());
                response.flushBuffer();
            } else {
                log.error("Log file not found");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (IOException ex) {
            log.error("Error writing file to output stream {}", ex);
        }
    }

    public String setLogLevel(String logLevel, String packageName) {

        String retVal;

        if (logLevel.equalsIgnoreCase("ALL")) {
            loggerContext.getLogger(packageName).setLevel(Level.ALL);
            retVal = "ok";
        } else if (logLevel.equalsIgnoreCase("DEBUG")) {
            loggerContext.getLogger(packageName).setLevel(Level.DEBUG);
            retVal = "ok";
        } else if (logLevel.equalsIgnoreCase("ERROR")) {
            loggerContext.getLogger(packageName).setLevel(Level.ERROR);
            retVal = "ok";
        } else if (logLevel.equalsIgnoreCase("INFO")) {
            loggerContext.getLogger(packageName).setLevel(Level.INFO);
            retVal = "ok";
        } else if (logLevel.equalsIgnoreCase("OFF")) {
            loggerContext.getLogger(packageName).setLevel(Level.OFF);
            retVal = "ok";
        } else if (logLevel.equalsIgnoreCase("TRACE")) {
            loggerContext.getLogger(packageName).setLevel(Level.TRACE);
            retVal = "ok";
        } else if (logLevel.equalsIgnoreCase("WARN")) {
            loggerContext.getLogger(packageName).setLevel(Level.WARN);
            retVal = "ok";
        } else {
            log.error("Not a known log level: " + logLevel);
            retVal = "Error, not a known log level: " + logLevel;
        }

        return retVal;
    }

}
