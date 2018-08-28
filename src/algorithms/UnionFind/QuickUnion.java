package algorithms.UnionFind;

public class QuickUnion {
    private  int[] id;
    private  int count;
    public QuickUnion(int N){
        id = new int[N];
        count = N;
        for (int i=0;i<N;i++)
            id[i] = i;
    }
    public int find(int point){
        while (id[point] != point)
            point = id[point];
        return point;
    }

    public void union(int pointa,int pointb){
        int aRoot = find(pointa);
        int bRoot = find(pointb);
        if (aRoot==bRoot)return;
        id[aRoot] = bRoot;
        count--;
    }


}
