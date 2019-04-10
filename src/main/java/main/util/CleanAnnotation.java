package main.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class CleanAnnotation {

    public static void clean(String fileName) throws IOException {
        Path p = Paths.get(fileName);
        byte[] bytes = Files.readAllBytes(p);
        String s  = new String(bytes);
        //remove 注释
        String s1 = s.replaceAll("(?<!:)\\/\\/.*|\\/\\*(\\s|.)*?\\*\\/", "");
        //has cleaned return
        if(s1.equals(s))
            return;


        // remove multi blank line
        s1 = s1.replaceAll("\r\n\r\n    ", "\r\n");  //windows
        s1  = s1.replaceAll("\n\n    ", "\n");      //linux
        PrintWriter pw = new PrintWriter(fileName);
        pw.print(s1);
        pw.close();
    }

    public static void cleanPackage(String packagePath) throws IOException {
        File f = new File(packagePath);
        if(!f.exists() || !f.isDirectory())
            throw new IllegalArgumentException("路径有问题");
        String[] list = f.list();
        for(String fileName: list)
        {
            String fullPath = packagePath + File.separator + fileName;
            clean(fullPath);
        }
    }


}
