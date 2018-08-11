package algorithms.sort;

import algorithms.utils.ListNode;

import static algorithms.utils.ArrayUtil.*;
import static algorithms.utils.ListNodeUtil.*;
public class QuickSort {
	
	
	public static void main(String[] args) {
        int[] a = generateRandomArray();
        printArray(a);
        quickSort(a);
        printArray(a);
        ListNode test = generateRandomListNode(10);
        System.out.println("linkedList sort");
        printListNode(test);
        printListNode(sortList(test));
    }
	//数组的实现
	public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }
	private static void quickSort(int[] a,int low,int high) {
		if (high<=low) {
			return;
		}
		int partition = partition(a, low, high);
		quickSort(a, low, partition-1);
		quickSort(a, partition+1, high);
	}

	private static int partition(int[] a,int low,int high) {
		int i=low+1,j=high;
		int value  = a[low];
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
			int temp = a[i];
			a[i] = a[j];
			a[j] =temp;
		}
		int temp = a[low];
		a[low] = a[j];
		a[j] = temp;
		
		return j;
	}
    //链表的实现
    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummyPre = new ListNode(0);
        dummyPre.next = head;
        quickSort(dummyPre,head,null);
        return dummyPre.next;

    }

    private static void quickSort(ListNode pre,ListNode head,ListNode end){
        if(head!=end&&head.next!=end){
            //head不再指向头结点，所以需要用pre
            ListNode partition = partition(pre,head,end);
            quickSort(pre,pre.next,partition);
            quickSort(partition,partition.next,end);
        }
    }
    private static ListNode partition(ListNode pre,ListNode low,ListNode high){
        ListNode dummyLow = new ListNode(0);
        ListNode dummyHigh = new ListNode(0);
        ListNode less = dummyLow;
        ListNode larger = dummyHigh;

        int value = low.val;
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
