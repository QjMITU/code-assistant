package org.zgd.code.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author thesky
 * @date 2022/7/14 10:09
 */
public class FileUtils {

   private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

   public static boolean createDir(String path){
       File file = new File(path);
       if (!file.exists()){
           return file.mkdirs();
       }
       return false;
   }

   public static void writeFile(String path,byte[] data){
        File file = new File(path);
        String dirPath = file.getParent();
        File dirs = new File(dirPath);
        if (!dirs.exists()){
            dirs.mkdirs();
            logger.info("Create dirs success:{}",dirPath);
        }
        if (!file.exists()){
            try (FileOutputStream outputStream = new FileOutputStream(file))
            {
                outputStream.write(data);
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("文件已经存在，无法覆盖");
        }
   }


    public static String readFile(String path){
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        if (inputStream==null){
            return "";
        }
        StringBuilder builder =new StringBuilder();
        int len = 0;
        do {
            try {
                byte[] bytes = new byte[1024];
                len = inputStream.read(bytes);
                if (len!=-1){
                    builder.append(new String(bytes,0,len,"UTF-8"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (len!=-1);
        return builder.toString();
    }


}
