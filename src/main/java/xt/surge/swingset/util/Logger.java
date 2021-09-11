package xt.surge.swingset.util;

/**
 * The Logger class (Not to be confused with java's built in logger) is a class
 * intended for creating files with information on how the game is running and 
 * performing.
 * 
 * @author Surge
 * @version 1.0
 */
public class Logger {
    
    /**
     * The Level class defines how a log level is created.
     */
    static class Level {
        private final String name, prf;
        
        /**
         * Creates a level with the specified name and prefix.
         * 
         * @param name The name of the level
         * @param prf The prefix of the level
         */
        public Level(String name, String prf) {
            this.name = name;
            this.prf = prf;
        }

        /**
         * Returns the name of the level
         * 
         * @return The name of the level
         */
        public String getName() {
            return name;
        }

        /**
         * Returns the prefix of the level
         * 
         * @return The prefix of the level
         */
        public String getPrefix() {
            return prf;
        }
    }

    /**
     * System defined log levels.
     */
    public static final Level TRACE = new Level("Trace", "TRC");
    public static final Level DEBUG = new Level("Debug", "DBG");
    public static final Level INFO = new Level("Info", "INF");
    public static final Level WARNING = new Level("Warning", "WRN");
    public static final Level ERROR = new Level("Error", "ERR");
    public static final Level CRITICAL = new Level("Critical", "CRT");
    public static final Level FATAL = new Level("Fatal", "FTL");

    /**
     * Logger name
     */
    protected String name;
    /**
     * Default logging level
     */
    protected Level defaultLevel;

    /**
     * Creates a new logger with the specified name. By default, the defaultLevel
     * is INFO.
     * 
     * @param loggerName The name of the logger
     */
    public Logger(String loggerName) {
        this.name = loggerName;
        this.defaultLevel = INFO;
    }

    /**
     * Creates a new logger with the specified name and default logging level.
     * 
     * @param loggerName The name of the logger
     * @param defaultLevel The default logging level of the logger
     */
    public Logger(String loggerName, Level defaultLevel) {
        this.name = loggerName;
        this.defaultLevel = defaultLevel;
    }

    /**
     * Logs a message to the console at the default logging level.
     * 
     * @param message The message to log
     */
    public void log(String message) {
        System.out.println("(" + name + ")[" + Time.getTimeString() + "]" + defaultLevel.getPrefix() + ":" + message);
    }

    /**
     * Logs a message to the console with the specified level.
     * 
     * @param message The message to log
     * @param level The level to log the message at
     */
    public void log(String message, Level level) {
        System.out.println("(" + name + ")[" + Time.getTimeString() + "]" + level.getPrefix() + ":" + message);
    }

    /**
     * Logs an exception.
     * 
     * @param e The exception to log
     * @param warning Whether or not the exception should be a warning instead of the default error
     * @param critical Whether or not the exception should be a critical error instead of the default error
     */
    public void logException(Exception e, boolean warning, boolean critical) {
        Level level = ERROR;
        if(warning) level = WARNING;
        if(critical) level = CRITICAL; //Overrides the warning parameter, because critical is at a higher level than warning

        log(e.getMessage(), level);
        for(StackTraceElement elem : e.getStackTrace()) {
            log("\t" + elem.toString(), TRACE); //Indent the text and log the stacktrace element
        }
    }

}
