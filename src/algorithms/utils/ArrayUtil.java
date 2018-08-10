package algorithms.utils;

public class ArrayUtil {
	private static Integer defaultNumber = 10;
	private static Integer randomRange = 20;
	
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
	public static void printrArray(Integer[] a) {
		for(Integer b:a) {
			System.out.print(b+" ");
		}
		System.out.println();
	}
	
}
