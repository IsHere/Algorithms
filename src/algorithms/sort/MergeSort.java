package algorithms.sort;

import algorithms.interfaces.GeneralSort;
import algorithms.utils.ProxyUtil;
import static algorithms.utils.ArrayUtil.*;

public class MergeSort implements GeneralSort {
	private Integer[] aux;

	public static void main(String[] args) {
		ProxyUtil.excuteSort(new MergeSort(), generateRandomArray(20));
	}
	@Override
	public void sort(Integer[] a) {
		aux = new Integer[a.length];
		sort(a,0,a.length-1);
		
		
		
	}
	private  void sort(Integer[] a,int low,int high) {
		if (low>=high) {
			return;
		}
		int mid = low+(high-low)/2;
		sort(a, low, mid);
		sort(a, mid+1, high);
		merge(a,low,mid,high);
	}
	//low -> mid和mid+1->hi两个子数组比较。
	private void merge(Integer[] a,Integer low,Integer mid,Integer hi) {
		Integer i = low;
		Integer j = mid+1;
		for(int n = low;n<=hi;n++) {
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
