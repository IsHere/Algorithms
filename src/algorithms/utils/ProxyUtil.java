package algorithms.utils;

import algorithms.interfaces.GeneralSort;
import algorithms.proxy.DynamicProxyTimeCaculateHandler;
import algorithms.proxy.TimeCaculateInterceptor;
import algorithms.sort.QuickSort;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static void excuteSort(GeneralSort sort, Integer[] a){
    	GeneralSort generalSortProxy = (GeneralSort)new DynamicProxyTimeCaculateHandler(sort).bind();
        generalSortProxy.sort(a);

    }
    public static Object createListSortProxy(String className) throws Exception {
    	Class<?> class1 = Class.forName(className);
    	TimeCaculateInterceptor timeCaculateInterceptor = new TimeCaculateInterceptor();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(class1);
		enhancer.setCallback(timeCaculateInterceptor);
		return enhancer.create();
    }
}
