package algorithms.sort;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import algorithms.interfaces.GeneralSort;
import algorithms.proxy.DynamicProxyTimeCaculateHandler;
import static algorithms.utils.ArrayUtil.*;

public class ShellSort implements GeneralSort {
	
	public static void main(String[] args) {
		GeneralSort shellSort = new ShellSort();
		GeneralSort shellSortproxy = (GeneralSort) 
				Proxy.newProxyInstance(GeneralSort.class.getClassLoader(), new Class[] {GeneralSort.class}, new DynamicProxyTimeCaculateHandler(shellSort));
		Integer[] a = generateRandomArray(20);
		printrArray(a);
		shellSortproxy.sort(a);
		printrArray(a);
		
		
	}
	@Override
	public void sort(Integer[] a) {
		Integer N = a.length;
		Integer h=1;
		while(h<N/3) h = h*3+1;
		// 将数组分割为长度为h的一个个小数组，然后将数组变为每隔h个值就有序。
		//这样做是为了避免插入排序的最坏情况进行N-1次移动，
		while(h>=1) {
			for(Integer i=h;i<N;i++) {
				for(Integer j=i;j>=h&&a[j]<a[j-h];j-=h) {
					Integer temp = a[j];
					a[j] = a[j-h];
					a[j-h] = temp;
				}
			}
			h = h/3;
		}
	}

}
