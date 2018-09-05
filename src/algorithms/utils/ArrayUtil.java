package algorithms.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
	private static Integer defaultNumber = 10;
	private static Integer randomRange = 20;
	
	public static Integer[] generateArray() {
		Integer[] aIntegers = new Integer[defaultNumber];
		for(int i=0;i<aIntegers.length;i++) {
			aIntegers[i] = i;
		}
		return aIntegers;
	}
	
	public static Integer[] generateRandomArray(Integer number) {
		Integer[] a = new Integer[10];
		for(Integer i=0;i<a.length;i++) {
			a[i] = (int) (Math.random() * number);
		}
		return a;
	}
	public static Integer[] generateRandomArray() {
		Integer[] a = new Integer[defaultNumber];
		for(Integer i=0;i<a.length;i++) {
			a[i] = (int) (Math.random() * randomRange);
		}
		return a;
	}
	public static Integer[] generateRandomArrayForheap() {
		Integer[] a = new Integer[defaultNumber+1];
		for(Integer i=1;i<a.length;i++) {
			a[i] = (int) (Math.random() * randomRange);
		}
		return a;
	}
	public static void printrArray(Integer[] a) {
		for(Integer b:a) {
			System.out.print(b+" ");
		}
		System.out.println();
	}
	public static void exch(Comparable<?>[] a,int i,int j) {
		Comparable<?> temp  = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static List<Integer> getRandomDataFromArray(Integer[] a) {
		List<Integer> result = new ArrayList<>();
		int length = a.length;
		while (length>0) {
			int randomIndex = (int)(Math.random()*length);
			result.add(a[randomIndex]);
			exch(a, randomIndex, length-1);
			length--;
		}
		return result;
	}
	public static void exch(Integer[] a,int i,int j) {
		Integer temp  = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
