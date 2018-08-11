package algorithms.utils;

import java.util.Vector;

public class ListNodeUtil {
	private static Integer randomRange = 20;

	public static ListNode generateListNode(Integer n) {
		ListNode temp = new ListNode();
		ListNode result = temp;
		for (Integer i = 1; i <= n; i++) {
			result.next = new ListNode(i);
			result = result.next;
		}
		return temp.next;
	}

	public static void printListNode(ListNode head) {
		if (null == head) {
			System.out.print("end");
			return;
		}
		System.out.print(head + " ");
		printListNode(head.next);
	}

	public static ListNode reverseListNode(ListNode head) {
		ListNode reverse = null;
		ListNode temp = head;
		while (temp != null) {
			ListNode next = temp.next;
			temp.next = reverse;
			reverse = temp;
			temp = next;
		}
		return reverse;
	}

	public static ListNode generateRandomListNode(Integer number) {
		ListNode result = new ListNode();
		ListNode temp = result;
		for (Integer i = 0; i < number; i++) {
			temp.next = new ListNode(getRandomNumber());
			temp = temp.next;
		}
		return result.next;
	}

	private static Integer getRandomNumber() {

		return (int) (Math.random() * randomRange);
	}
}
