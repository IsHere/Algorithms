package algorithms.dateStructure;



public class TreeNode {
	public Integer val;
	public Integer key;
	public TreeNode right;
	public TreeNode left;
	public int N;	//�ýڵ�Ϊ�����ӽڵ������

	public TreeNode(Integer val, Integer key, int n) {
		this.val = val;
		this.key = key;
		N = n;
	}
	public TreeNode(){}
}
