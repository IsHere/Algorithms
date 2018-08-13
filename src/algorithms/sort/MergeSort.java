package algorithms.sort;

import algorithms.interfaces.GeneralSort;

public class MergeSort implements GeneralSort {
	private Integer[] aux;

	@Override
	public void sort(Integer[] a) {
		aux = new Integer[a.length];
		
		
		
	}
	//low -> mid��һ���ָ����飬mid+1->hi��һ���ָ�����
	private void merge(Integer[] a,Integer low,Integer mid,Integer hi) {
		Integer i = low;
		Integer j = mid+1;
		for(int n = low;n<hi;n++) {
			aux[n] = a[n];
		}
		for(int k = low;k<=hi;k++) {
			//����һ���������������������һ�����鲢û��
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
