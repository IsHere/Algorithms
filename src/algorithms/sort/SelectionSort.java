package algorithms.sort;

import static algorithms.utils.ArrayUtil.generateRandomArray;
import static algorithms.utils.ArrayUtil.printArray;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a = generateRandomArray();
		printArray(a);
		sort(a);
		printArray(a);
	}
	//���������Ȼ����ѡ���������ôһ������....
	public static void sort(int[] a) {
		for(int i=0;i<a.length;i++) {
			for(int j = i+1;j<a.length;j++) {
				if (a[j]<a[i]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}
