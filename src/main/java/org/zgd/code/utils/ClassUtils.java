package org.zgd.code.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author thesky
 * @date 2022/7/15 14:15
 */
public class ClassUtils {

    public static Set<Class<?>> addClassToSet(String entityFullPath){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(entityFullPath.replace(".", "/"));
        HashSet<Class<?>> classHashSet = new HashSet<>();
        if (resource.getProtocol().equalsIgnoreCase("file")){
            File file = new File(resource.getPath());
            List<String> classNames = filterClass(file, entityFullPath);
            try {
                for (String className : classNames) {
                    Class<?> loadClass = classLoader.loadClass(className);
                    classHashSet.add(loadClass);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return classHashSet;
    }

    private static List<String> filterClass(File fileResource, String entityFullPath){
        ArrayList<String> list = new ArrayList<>();
        if (fileResource.isDirectory()){
            File[] files = fileResource.listFiles(file -> {
                if (file.isDirectory()) {
                    return true;
                } else {
                    String absolutePath = file.getAbsolutePath();
                    if (absolutePath.endsWith(".class")) {
                        absolutePath = absolutePath.replace(File.separator,".");
                        String className = absolutePath.substring(absolutePath.indexOf(entityFullPath),absolutePath.lastIndexOf("."));
                        list.add(className);
                    }
                }
                return false;
            });
        }
        return list;
    }

}
