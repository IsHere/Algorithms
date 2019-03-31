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
			//��i��ǰ����������бȵ�ǰֵ��ģ�����ֵǰ�ƣ����ǵý���ǰֵ����
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
        //first���ź���ڵ��еĵ����һ���ڵ㣬pointΪδ����Ľڵ�
        ListNode point = head.next;
        ListNode first = head;
        while(point != null){
            //��Ϊ�������飬����ֻ��ÿ�δ�ͷ����
            ListNode current = result.next;
            ListNode pre = result;
            while(point != current && point.val >= current.val){
                current = current.next;
                pre = pre.next;
            }
            if(current == point){
                first = point;
            }
            //����ָ���ҵ�����point��ʱ�򽫽ڵ����
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
