package algorithms.search;

import algorithms.utils.ArrayUtil;
import algorithms.utils.ProxyUtil;
import org.junit.Test;

public class BinarySearch {

	//仅适用于排好序的
	public int search(Integer[] array, int a) {
		int low = 0;
		int high = array.length-1;
		while(low<high) {
			int middle = (low+high)/2;
			if (a==array[middle]) {
				return middle;
			}
			else if (a<array[middle]) {
				high = middle-1;
			}
			else {
				low = middle+1;
			}
		}
		return -1;
	}
	@Test
	public void test(){
		Integer[] a = ArrayUtil.generateArray();
		try {
			BinarySearch binarySearch = (BinarySearch) ProxyUtil.createListSortProxy(this.getClass().getName());
            System.out.println(binarySearch.search(a,4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
