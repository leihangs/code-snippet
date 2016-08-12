package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    Logger logger = LoggerFactory.getLogger(getClass());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //5秒钟一次
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        logger.info("The time is now " + dateFormat.format(new Date()));
    }


    //1分钟一次
    @Scheduled(cron= "0 */1 * * * ?")
    public void reportCurrentTime2() {
        logger.info("The time2 is now " + dateFormat.format(new Date()));
    }


}