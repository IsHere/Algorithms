package algorithms.sort;

import static algorithms.utils.ArrayUtil.generateRandomArray;
import static algorithms.utils.ArrayUtil.*;

import algorithms.interfaces.GeneralSort;
import algorithms.utils.ProxyUtil;

public class SelectionSort implements GeneralSort {

	public static void main(String[] args) {
		 ProxyUtil.excuteSort(new BubbleSort(), generateRandomArray());
	}
	//���������Ȼ����ѡ���������ôһ������....
	@Override
	public  void sort(Integer[] a) {
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
