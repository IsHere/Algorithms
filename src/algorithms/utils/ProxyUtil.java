package algorithms.utils;

import algorithms.interfaces.GeneralSort;
import algorithms.proxy.DynamicProxyTimeCaculateHandler;
import algorithms.sort.QuickSort;

import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static void excuteSort(GeneralSort sort, Integer[] a){
        GeneralSort generalSortProxy =
                (GeneralSort) Proxy.newProxyInstance(GeneralSort.class.getClassLoader(),
                        new Class[]{GeneralSort.class},
                        new DynamicProxyTimeCaculateHandler(sort));
        generalSortProxy.sort(a);

    }
}
