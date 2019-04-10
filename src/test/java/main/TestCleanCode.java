package main;


import main.util.CleanAnnotation;
import org.junit.Test;

import java.io.IOException;

public class TestCleanCode {

    @Test
    public void clean()
    {
        try {
            CleanAnnotation.clean("D:\\Users\\zmz\\idea\\springboot-mybatis-test\\src\\main\\java\\generator\\dao\\HomeworkMapper.java");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCleanPackage()
    {
        try {
            CleanAnnotation.cleanPackage("D:\\Users\\zmz\\idea\\Faxianbei\\src\\main\\java\\main\\model\\po");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCleanPackageOnLinux()
    {
        try {
            CleanAnnotation.cleanPackage("/home/zmz/workspace/IdeaProjects/Faxianbei/src/main/java/main/dao");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCleanPackageModelOnLinux()
    {
        try {
            CleanAnnotation.cleanPackage("/home/zmz/workspace/IdeaProjects/Faxianbei/src/main/java/main/model/po");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
