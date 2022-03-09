package pers.yangzhen.exceptionandlog;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class LoggerTest {
    // Usually, modify logger with static final to avoid garbage collection,
    // and set package name as the name of logger
    private static final Logger logger = Logger.getLogger("pers.yangzhen.exceptionandlog");
    
    // show logging
    @Test
    public void test1() {
        // quick logging
        logger.info("hello jul");
        // or logging by general method
        logger.log(Level.INFO, "hello jul");
        // output value of variable
        String name = "ZhangSan";
        int age = 100;
        logger.log(Level.INFO,"User: {0},{1}",new Object[]{name,age});
    }
    
    // log level
    @Test
    public void test2(){
        // default: just record the first three levels, and output on console,
        // besides, console just display the first three record logs without setting ConsoleHandler.
        // if we want to record all levels, just need to invoke logger.setLevel(Level.ALL).
        // if we want to display all record logs on console,
        // just need to invoke consoleHandler.setLevel(Level.ALL).
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        // just select one to debug logging from the last three levels
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
        // set log level, OFF means not record logs
        logger.setLevel(Level.OFF);
        logger.severe("test");
        logger.warning("test");
        System.out.println("-----------------------");
        // set log level, ALL means record all logs
        // but on the console,
        logger.setLevel(Level.ALL);
        logger.severe("test");
        logger.warning("test");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
    
    // customize the log output
    @Test
    public void test3() throws IOException {
        // firstly, close system default config
        logger.setUseParentHandlers(false);
        
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // set format
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        // record all logs
        logger.setLevel(Level.ALL);
        // output all recorded logs on console,
        // but, similarly, console just output first three levels by default without
        // invoking consoleHandler.setLevel(Level.ALL)
        consoleHandler.setLevel(Level.ALL);
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    
        System.out.println("-----------------");
        // output all record logs on file named "jul.log"
        FileHandler fileHandler = new FileHandler("./src/pers/yangzhen/exceptionandlog/logs/jul.log");
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
    
    // loading custom configurations from file logging.properties
    @Test
    public void test4() throws IOException {
        InputStream ins = new FileInputStream("E:/IDEAProject/JavaBasics/logging.properties");
        // load configurations by LogManager instance
        LogManager logManager = LogManager.getLogManager();
        logManager.readConfiguration(ins);
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
        System.out.println("-------------------------");
        // load default properties
        Logger logger2 = Logger.getLogger("test");
        logger2.severe("severe test");
        logger2.warning("warning test");
        logger2.info("info test");
        logger2.config("config test");
        logger2.fine("fine test");
        logger2.finer("finer test");
        logger2.finest("finest test");
    }
}
