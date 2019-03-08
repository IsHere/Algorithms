package algorithms.dateStructure;



public class TreeNode {
	public Integer val;
	public Integer key;
	public TreeNode right;
	public TreeNode left;
	public int N;	//该节点为根的子节点的总数

	public TreeNode(Integer val, Integer key, int n) {
		this.val = val;
		this.key = key;
		N = n;
	}
	public TreeNode(){}
}
