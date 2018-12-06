package applicationInsight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LogService implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogService.class);
    private ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    private final static Long WAIT_TIME = 1L;

    void startService() {
        scheduledExecutor.schedule(this, WAIT_TIME, TimeUnit.MINUTES);
    }

    @Override
    public void run() {
        org.apache.logging.log4j.ThreadContext.put("ThreadContext", "deviceIdLogServiceThreadContext");
        LOGGER.trace("Message body for TRACE");
        LOGGER.debug("Message body for DEBUG");
        LOGGER.info("Message body for INFO");
        LOGGER.warn("Message body for WARN");
        LOGGER.error("Message body for ERROR");
        scheduledExecutor.schedule(this, WAIT_TIME, TimeUnit.SECONDS);
    }
}
