package algorithms.sort;

import static algorithms.utils.ArrayUtil.generateRandomArray;

import algorithms.interfaces.GeneralSort;
import algorithms.dateStructure.ListNode;
import algorithms.utils.ProxyUtil;

public class InsertSort implements GeneralSort {
	
	public static void main(String[] args) {
		 ProxyUtil.excuteSort(new BubbleSort(), generateRandomArray());
	}
	@Override
	public  void sort(Integer[] a ) {
		for(int i=1;i<a.length;i++) {
			int temp = a[i];
			int j;
			//从i向前遍历，如果有比当前值大的，则大的值前移，最后记得将当前值插入
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
