package algorithms.sort;

import algorithms.interfaces.GeneralSort;
import algorithms.utils.ProxyUtil;

import static algorithms.utils.ArrayUtil.*;

import java.util.Arrays;
import java.util.List;

public class HeapSort implements GeneralSort {
	public static void main(String[] args) {
		ProxyUtil.excuteSort(new HeapSort(), generateRandomArrayForheap());
	}

	// ����һ�������Ч�ķ�����������ҵ���sink()
	// �е����...��Ϊ�������±�����ʾ����ѵ�ʱ��index=0�ĵط�һ��Ҫ��ȥ
	// index=0,child��Ϊ1��2������index*2=0����һ�׾Ͳ�ͬ���ˣ��ǲ��Ƕ���������Ҫ��ô...
	public void sort(Integer[] a) {
		int N = a.length - 1;
		//���������ֵ����ǰ��
		for (int k = N / 2; k >= 1; k--)
			sink(a, k, N);
		//�����ֵ�ŵ���������棬Ȼ����ͨ��sink������֤��һ��ֻһ�������ֵ��
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}

	private void sink(Integer[] a, int k, int N) {
		while (2 * k <= N) {
			int child = 2 * k;
			if (child < N && a[child] < a[child + 1]) {
				child++;
			}
			if (a[k] >= a[child]) {
				break;
			}
			exch(a, k, child);
			k = child;
		}
	}

	private void exch(Integer[] a, Integer i, Integer j) {
		Integer temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
