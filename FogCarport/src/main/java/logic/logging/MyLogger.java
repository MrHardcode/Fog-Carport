/*
 *  
 */
package logic.logging;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class MyLogger
{
    private final static String PATH = ""; // INSERT ABSOLUTE PATH HERE BEFORE WE GO LIVE AND MAKE SURE TO HAVE THE RIGHT PERMISSIONS.
    private final static Logger LOGGER = Logger.getLogger(logic.logging.MyLogger.class.getName());

    public static Logger getLogger() throws java.io.IOException
    {
            LOGGER.addHandler(new ConsoleHandler());
            FileHandler handler = new FileHandler(PATH + "\\log.%u.%g.txt");
            handler.setFormatter(new StackTraceFormatter());
            LOGGER.addHandler(handler);
            return LOGGER;
    }

    private static class StackTraceFormatter extends Formatter
    {

        private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

        @Override
        public String format(final LogRecord record) // Throwable from FrontController. The "ex".
        {
            StackTraceElement[] traces = record.getThrown().getStackTrace();
            StringBuilder sb = new StringBuilder("Stacktrace: \n--------------------------------------------------------\n");
            for (StackTraceElement trace : traces) // For each line in the stacktrace.
            {
                sb.append("Line number: ").append(trace.getLineNumber()).append("in Method: ").append(trace.getMethodName()).append(" in class ").append(trace.getClassName()).append(" in file: ").append(trace.getFileName()).append("\n");
            }
            return String.format( 
                    "%1$s %2$-7s %3$s %4$s\n",
                    new SimpleDateFormat(PATTERN).format(new Date(record.getMillis())),
                    record.getLevel().getName(),
                    formatMessage(record),
                    sb.toString()
            );
        }
    }
}
