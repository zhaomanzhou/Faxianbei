package main;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void test01()
    {
        logger.debug("ddd");
    }
}
