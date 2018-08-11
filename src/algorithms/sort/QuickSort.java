package algorithms.sort;

import algorithms.utils.ListNode;

import static algorithms.utils.ArrayUtil.*;

import java.lang.reflect.Proxy;

import algorithms.interfaces.GeneralSort;
import algorithms.proxy.DynamicProxyTimeCaculateHandler;
public class QuickSort implements GeneralSort{
	
	public static void main(String[] args) {
		GeneralSort quickSort = new QuickSort();
		GeneralSort quickSortProxy = 
				(GeneralSort)Proxy.newProxyInstance(GeneralSort.class.getClassLoader(), 
				new Class[] {GeneralSort.class},
				new DynamicProxyTimeCaculateHandler(quickSort));
		Integer[] a = generateRandomArray(100);
		printrArray(a);
		quickSortProxy.sort(a);
		printrArray(a);
	}
	
	//数组实现
	public  void sort(Integer[] a) {
        quickSort(a, 0, a.length - 1);
    }
	private  void quickSort(Integer[] a,Integer low,Integer high) {
		if (high<=low) {
			return;
		}
		Integer partition = partition(a, low, high);
		quickSort(a, low, partition-1);
		quickSort(a, partition+1, high);
	}

	private  Integer partition(Integer[] a,Integer low,Integer high) {
		Integer i=low+1,j=high;
		Integer value  = a[low];
		while(true) {
			while(a[i]<value) {
				if (i==high) {
					break;
				}
				i++;
			}
			while(a[j]>value) {
				j--;
			}
			if (i>=j) {
				break;
			}
			Integer temp = a[i];
			a[i] = a[j];
			a[j] =temp;
		}
		Integer temp = a[low];
		a[low] = a[j];
		a[j] = temp;
		
		return j;
	}
    //List实现
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummyPre = new ListNode(0);
        dummyPre.next = head;
        quickSort(dummyPre,head,null);
        return dummyPre.next;

    }

    private void quickSort(ListNode pre,ListNode head,ListNode end){
        if(head!=end&&head.next!=end){
            //head涓嶅啀鎸囧悜澶寸粨鐐癸紝鎵�浠ラ渶瑕佺敤pre
            ListNode partition = partition(pre,head,end);
            quickSort(pre,pre.next,partition);
            quickSort(partition,partition.next,end);
        }
    }
    private ListNode partition(ListNode pre,ListNode low,ListNode high){
        ListNode dummyLow = new ListNode(0);
        ListNode dummyHigh = new ListNode(0);
        ListNode less = dummyLow;
        ListNode larger = dummyHigh;

        Integer value = low.val;
        ListNode cursor = low.next;
        while(cursor!=high){
            if(value>cursor.val){
                less.next = cursor;
                less = less.next;
            }
            else{
                larger.next = cursor;
                larger = larger.next;
            }
            cursor = cursor.next;
        }
        larger.next = high;
        low.next = dummyHigh.next;
        less.next = low;
        pre.next = dummyLow.next;
        return low;
    }
	
}
