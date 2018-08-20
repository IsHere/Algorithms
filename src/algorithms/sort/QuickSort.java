package algorithms.sort;

import algorithms.utils.ListNode;
import algorithms.utils.ProxyUtil;

import static algorithms.utils.ArrayUtil.*;

import java.lang.reflect.Proxy;

import algorithms.interfaces.GeneralSort;
import algorithms.proxy.DynamicProxyTimeCaculateHandler;
public class QuickSort implements GeneralSort{
	
	public static void main(String[] args) {
		ProxyUtil.excuteSort(new QuickSort(), generateRandomArray(20));
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

	//三向切分，和上面的比起来区别在于当前值的位置是一直动的
	//这个方法一次计算之后，作为对比的那个值该是i->j的的中间。
	//所以递归的参数是(low->current)和(j->high]
	public  void sort(Comparable[] a,int low,int high) {
		if (high<=low) {
			return;
		}
		int current = low;int i=low+1;int j = high;
		Comparable value = a[low];
		while(i<=j) {
			int flag = a[i].compareTo(value);
			if (flag<0) {
				exch(a, current++, i++);
			}
			else if (flag>0) {
				exch(a, i, j--);
			}
			else {
				i++;
			}
			sort(a, low, current-1);
			sort(a, j+1, high);
		}
	}
	//第二个循环的判断可删除，因为j==lowd的时候必定等于跳出循环。
	//
	private  Integer partition(Integer[] a,Integer low,Integer high) {
		Integer i=low,j=high+1;
		Integer value  = a[low];
		while(true) {
			while(a[++i]<value) {
				if (i==high) {
					break;
				}
			}
			while(a[--j]>value) {
				if (j==low) {
					break;
				}
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
            //head在执行partition之后不再指向头结点，所以使用pre
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
