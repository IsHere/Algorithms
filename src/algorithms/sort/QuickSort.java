package algorithms.sort;

import static algorithms.utils.ArrayUtil.*;
public class QuickSort {
	
	
	public static void main(String[] args) {
		int[] a = generateRandomArray();
		printArray(a);
		quickSort(a);
		printArray(a);
	}
	
	public static void quickSort(int[] a) {
		quickSort(a,0,a.length-1);
	}
	
	private static void quickSort(int[] a,int low,int high) {
		if (high<=low) {
			return;
		}
		int partition = partition(a, low, high);
		quickSort(a, low, partition-1);
		quickSort(a, partition+1, high);
	}

	private static int partition(int[] a,int low,int high) {
		int i=low+1,j=high;
		int value  = a[low];
		while(true) {
			while(a[i]<value) {
				if (i==high) {
					break;
				}
				i++;
			}
			while(a[j]>value) {
				j--;
			}
			if (i>=j) {
				break;
			}
			int temp = a[i];
			a[i] = a[j];
			a[j] =temp;
		}
		int temp = a[low];
		a[low] = a[j];
		a[j] = temp;
		
		return j;
	}
}
