package main;

import org.junit.Test;

public class BasicTest {

    private int a = 0xFFFFFFFF;


    @Test
    public void test(){
        String s = "test -e test/file/path";
        //String s = "dd";
        System.out.println(s.length());

    }

}
