package algorithms.sort;

import static algorithms.utils.ArrayUtil.generateRandomArray;
import static algorithms.utils.ArrayUtil.*;

import algorithms.interfaces.GeneralSort;

public class SelectionSort implements GeneralSort {

	public static void main(String[] args) {
		
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
