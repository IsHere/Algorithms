package algorithms.utils;



public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
	public ListNode() {}

	public boolean equals(ListNode ListNode) {
		return null!=ListNode&&this.val == ListNode.val;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.val);
	}
}
