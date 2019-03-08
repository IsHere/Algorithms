package algorithms.dateStructure;

public class MaxPQ {
    //�������������飬Ȼ�����delMax��ʱ����һ��ð����ɾ�������β������
    //�������������飬����ÿ�β����ʱ�����һ������Ȼ��delMax��ʱ��ֱ��ɾ�����һλ����
    //���Ͻ�������ʹ�ö����
    //��������ÿ���ڵ㶼���ڵ����ӽڵ㣬���Ϊ������������˵��ÿ��delMaxֻҪɾ�����ڵ㼴�ɡ�
    //������������ʵ��һ������������ĳ�ڵ�ĸ��ڵ�Ϊi/2,�ӽڵ�Ϊ2*i+1��2*i
	private Integer[] pq;
	private int N =0;//��0λ��ʹ��
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
        exch(1, N--);//����һ�������һ����������size-1
        pq[N+1] = null;//���������Ǹ�ֵ���
        sink(1);//�ָ�����
        return max;
        
    }
    boolean isEmpty(){
        return N==0;
    }
    int size(){
        return N;
    }
    //�ӽڵ���ڸ��ڵ㣬�ϸ�
    private void swim(int k) {
    	while(k>1&&pq[k/2]<pq[k]) {
    		exch(k/2, k);
    		k = k/2;
    	}
    }
    //���ڵ�С���ӽڵ�
    private void sink(int k) {
    	while(2*k<=N) {
    		int j = 2*k;
    		//Ҫ�ͽϴ�ıȽ�
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
