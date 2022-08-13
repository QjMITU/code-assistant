package org.zgd.code.domain.base;

/**
 * @author thesky
 * @date 2022/7/14 10:30
 */
public class SystemProperty {

    public static String projectPath = System.getProperty("user.dir");
    public static String javaPath = projectPath+"\\src\\main\\java";
    public static String resourcePath = projectPath+"\\src\\main\\resources";
    public static String separator = System.getProperty("file.separator");
    public static String username = System.getProperty("user.name");
    public static String userhome = System.getProperty("user.home");

}
