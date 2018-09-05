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

	// 构造一个堆最高效的方法是数组从右到左sink()
	// 有点蠢啊...因为用数组下标来表示二叉堆的时候，index=0的地方一定要舍去
	// index=0,child该为1和2，但是index*2=0，这一套就不同用了，那不是对于输入有要求么...
	public void sort(Integer[] a) {
		int N = a.length - 1;
		//堆有序，最大值在最前面
		for (int k = N / 2; k >= 1; k--)
			sink(a, k, N);
		//将最大值放到数组最后面，然后再通过sink操作保证第一个只一定是最大值。
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
