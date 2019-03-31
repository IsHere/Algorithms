package IOC.IOCUtil;


import java.io.File;
import java.util.*;

public class ClassUtil {
    private static Set<Class<?>> classSet = new HashSet<>();

    public static Set<Class<?>> getClassSet() {
        List<String> fileList = new ArrayList<>();
        ClassUtil classUtil = new ClassUtil();
        searchFile(classUtil.getBasePath(), "", fileList);
        for (String s : fileList) {
            doAddClass(classSet, s);
        }
        return classSet;

    }

    private  String getBasePath() {
        return this.getClass().getResource("/").getPath();
    }

    private static void searchFile(String basePath, String relativePath, List<String> list) {
        File[] directories = new File(basePath).listFiles(File::isDirectory);

        setClassPath(basePath, relativePath, list);
        if (directories != null) {
            for (File file : directories) {
                String relativePath1 = relativePath.isEmpty() ? file.getName() : relativePath + "." + file.getName();
                searchFile(basePath + "/" + file.getName(), relativePath1, list);
            }
        }


    }

    private static void setClassPath(String basePath, String relativePath, List<String> list) {

        File[] files = new File(basePath).listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(".class"));
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                list.add(relativePath.isEmpty() ? fileName : relativePath + "." + fileName.substring(0, fileName.lastIndexOf(".")));
            }
        }

    }


    private static void doAddClass(Set<Class<?>> classSet, String className) {
        Class<?> cls = loadClass(className);
        classSet.add(cls);
    }

    private static Class<?> loadClass(String className) {
        Class<?> cls ;
        try {
            cls = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cls;
    }
//
//    /*获取类加载器*/
//    private static ClassLoader getClassLoader() {
//        return Thread.currentThread().getContextClassLoader();
//    }

}
