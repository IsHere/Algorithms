package algorithms.sort;

import static algorithms.utils.ArrayUtil.generateRandomArray;
import static algorithms.utils.ArrayUtil.printArray;

import algorithms.utils.ListNode;

public class InsertSort {
	
	public static void main(String[] args) {
		
		int[] a = generateRandomArray();
		printArray(a);
		insertSort(a);
		printArray(a);
	}
	public static void insertSort(int[] a ) {
		for(int i=1;i<a.length;i++) {
			int temp = a[i];
			int j;
			for(j=i;j>0 && temp<a[j-1];j--) {
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next ==null)return head;
        ListNode result = new ListNode(0);
        result.next = head;
        //first是排好序节点中的的最后一个节点，point为未排序的节点
        ListNode point = head.next;
        ListNode first = head;
        while(point != null){
            //因为不是数组，所以只能每次从头遍历
            ListNode current = result.next;
            ListNode pre = result;
            while(point != current && point.val >= current.val){
                current = current.next;
                pre = pre.next;
            }
            if(current == point){
                first = point;
            }
            //遍历指针找到大于point的时候将节点插入
            else{
                first.next = point.next;
				point.next = current;
				pre.next = point;
            }
            point = first.next;
        }
        return result.next;
    }

}
