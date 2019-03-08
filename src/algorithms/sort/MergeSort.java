package algorithms.sort;

import algorithms.interfaces.GeneralSort;
import algorithms.proxy.TimeCaculateInterceptor;
import algorithms.utils.ProxyUtil;
import net.sf.cglib.proxy.Enhancer;

import static algorithms.utils.ArrayUtil.*;

import java.util.Arrays;

public class MergeSort implements GeneralSort {
	private Integer[] aux;

	public static void main(String []args){
        ProxyUtil.excuteSort(new MergeSort(), generateRandomArray());
       
       
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
		int mid = (high+low)/2;
		sort(a, low, mid);
		sort(a, mid+1, high);
		merge(a,low,mid,high);
	}
	//[i=low -> mid]和[j=mid+1->hi]两个子数组比较。
	private void merge(Integer[] a,Integer low,Integer mid,Integer hi) {
		Integer i = low;
		Integer j = mid+1;
		System.arraycopy(a, low, aux, low, hi + 1 - low);
		int k=low;
		while(k<=hi) {
			//其中一个数组遍历结束，但是另一个数组并没有
			if (i>mid) {
				a[k++] = aux[j++];
			}
			else if (j>hi) {
				a[k++] = aux[i++];
			}
			else if (aux[j]<=aux[i]) {
				a[k++] = aux[j++];
			}
			else {
				a[k++] = aux[i++];
			}
		}
		
	}
}
