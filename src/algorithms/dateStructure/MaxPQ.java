package algorithms.dateStructure;

public class MaxPQ {
    //可以是无序数组，然后调用delMax的时候用一次冒泡来删除数组结尾的数据
    //可以是有序数组，就是每次插入的时候进行一次排序，然后delMax的时候直接删除最后一位数字
    //书上讲述的是使用二叉堆
    //二叉树的每个节点都大于等于子节点，则成为堆有序，依次来说，每次delMax只要删除根节点即可。
    //这里用数组来实现一个二叉树，则某节点的父节点为i/2,子节点为2*i+1和2*i
	private Integer[] pq;
	private int N =0;//第0位不使用
    public MaxPQ(){}
    public MaxPQ(int max){
    	pq = new Integer[max];
    }
    public MaxPQ(int[] a){}
    void insert(int v){
    	pq[++N]=v;
    	swim(N);
    }
    int delMax(){
        int max = pq[1];
        exch(1, N--);//将第一个和最后一个交换并且size-1
        pq[N+1] = null;//将交换的那个值设空
        sink(1);//恢复有序
        return max;
        
    }
    boolean isEmpty(){
        return N==0;
    }
    int size(){
        return N;
    }
    //子节点大于父节点，上浮
    private void swim(int k) {
    	while(k>1&&pq[k/2]<pq[k]) {
    		exch(k/2, k);
    		k = k/2;
    	}
    }
    //父节点小于子节点
    private void sink(int k) {
    	while(2*k<=N) {
    		int j = 2*k;
    		//要和较大的比较
    		if (j<N&&pq[j]<pq[j+1]) {
				j++;
			}
    		if (!(pq[k]<pq[j])) {
				break;
			}
    		exch(k, j);
    		k=j;
    	}
    }
    private void exch(int i,int j) {
    	int temp = pq[i];
    	pq[i] = pq[j];
    	pq[j] = temp;
    }

}
