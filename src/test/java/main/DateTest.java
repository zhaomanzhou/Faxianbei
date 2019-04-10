package main;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");

    @Test
    public void test01()
    {
        System.out.println(sdf.format(new Date(System.currentTimeMillis() + 1000L*60*60*24) ));
    }
}
