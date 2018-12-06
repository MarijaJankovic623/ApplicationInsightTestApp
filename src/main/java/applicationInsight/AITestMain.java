package applicationInsight;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;
import org.apache.logging.log4j.core.lookup.MainMapLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AITestMain {

    private static final String INSIGHT_KEY = "***";
    private static final Logger LOGGER = LoggerFactory.getLogger(AITestMain.class);

    static {
        System.setProperty("GatewayIdSys", "deviceIdSystemProperty");
        System.setProperty("applicationinsights.configurationDirectory", "src/main//resources");
        System.setProperty("log4j.configurationFile", "/resources/log4j2.xml");
    }

    public static void main(String[] args) {
        org.apache.logging.log4j.ThreadContext.put("ThreadContext", "deviceIdMainThreadContext");
        LOGGER.info("Starting Application Insight Test App");

        MainMapLookup.setMainArguments("deviceIdMainLookupContext");

        TelemetryConfiguration.getActive().setInstrumentationKey(INSIGHT_KEY);
        TelemetryClient telemetry = new TelemetryClient();
        telemetry.trackMetric("gatewayIdAsMetric", 26);


        LogService logService = new LogService();
        logService.startService();

        FinishService finishService = new FinishService();
        finishService.startService();

    }
}
