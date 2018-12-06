package applicationInsight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FinishService implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(FinishService.class);
    private ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    private final static Long FINISH_TIME = 2L;

    void startService() {
        scheduledExecutor.schedule(this, FINISH_TIME, TimeUnit.MINUTES);
    }

    @Override
    public void run() {
        org.apache.logging.log4j.ThreadContext.put("ThreadContext", "deviceIdFinishServiceThreadContext");
        LOGGER.info("Shutting down Application Insight Test App");
        System.exit(0);
    }
}
