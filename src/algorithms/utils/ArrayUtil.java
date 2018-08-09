package algorithms.utils;

public class ArrayUtil {
	private static int defaultNumber = 10;
	private static int randomRange = 20;
	
	public static int[] generateRandomArray(int number) {
		int[] a = new int[10];
		for(int i=0;i<a.length;i++) {
			a[i] = (int) (Math.random() * number);
		}
		return a;
	}
	public static int[] generateRandomArray() {
		int[] a = new int[defaultNumber];
		for(int i=0;i<a.length;i++) {
			a[i] = (int) (Math.random() * randomRange);
		}
		return a;
	}
	public static void printArray(int[] a) {
		for(int b:a) {
			System.out.print(b+" ");
		}
		System.out.println();
	}
	
}
