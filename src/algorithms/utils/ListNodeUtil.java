package algorithms.utils;

public class ListNodeUtil {
	private static int randomRange = 20;

	public static ListNode generateListNode(int n) {
		ListNode temp = new ListNode();
		ListNode result = temp;
		for (int i = 1; i <= n; i++) {
			result.next = new ListNode(i);
			result = result.next;
		}
		return temp.next;
	}

	public static void printListNode(ListNode head) {
		if (null == head) {
			System.out.println("end");
			return;
		}
		System.out.printf(head + " ");
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

	public static ListNode generateRandomListNode(int number) {
		ListNode result = new ListNode();
		ListNode temp = result;
		for (int i = 0; i < number; i++) {
			temp.next = new ListNode(getRandomNumber());
			temp = temp.next;
		}
		return result.next;
	}

	private static int getRandomNumber() {

		return (int) (Math.random() * randomRange);
	}
}
