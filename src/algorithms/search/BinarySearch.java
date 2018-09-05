package algorithms.search;

public class BinarySearch {

	//仅适用于排好序的
	public int search(int[] array, int a) {
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
}
