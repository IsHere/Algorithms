package IOCUtil;


import algorithms.annotation.Autowire;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanFactory {
   private static Map<String, Object> classMap = new HashMap<>();

    public BeanFactory(){
        registerClass();
    }

    public  Object getClassByName(String name){
        return classMap.get(name);
    }

    private static void registerClass() {

        Set<Class<?>> classes = ClassUtil.getClassSet();
        try {
            for (Class<?> c :
                    classes) {
                if (!c.isAnnotation() && c.getAnnotations().length > 0) {
                    String className = c.toString();
                    classMap.put(className.lastIndexOf(".") > 0 ? className.substring(className.lastIndexOf(".") + 1) : className, c.newInstance());
                }
            }
            setClassProp();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void setClassProp() {
        try {
            for (String key : classMap.keySet()) {
                Object instance = classMap.get(key);
                Field[] f = instance.getClass().getDeclaredFields();
                // 获得被注解的属性
                for (Field ff : f) {
                    Autowire anno = ff.getAnnotation(Autowire.class);
                    if (anno != null) {
                        // 给context里面的class注入
                        instance.getClass()
                                .getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1),
                                        Class.forName(ff.getType().getName()))
                                .invoke(instance, Class.forName(ff.getType().getName()).newInstance());

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
