package algorithms.sort;

import algorithms.interfaces.GeneralSort;

public class MergeSort implements GeneralSort {
	private Integer[] aux;

	@Override
	public void sort(Integer[] a) {
		aux = new Integer[a.length];
		
		
		
	}
	//low -> mid是一个分割数组，mid+1->hi是一个分割数组
	private void merge(Integer[] a,Integer low,Integer mid,Integer hi) {
		Integer i = low;
		Integer j = mid+1;
		for(int n = low;n<hi;n++) {
			aux[n] = a[n];
		}
		for(int k = low;k<=hi;k++) {
			//其中一个数组遍历结束，但是另一个数组并没有
			if (i>mid) {
				a[k] = a[j++];
			}
			else if (j>hi) {
				a[k] = a[i++];
			}
			else if (aux[j]<aux[i]) {
				a[k] = aux[j++];
			}
			else {
				a[k] = aux[i++];
			}
		}
		
	}
	
	

}
