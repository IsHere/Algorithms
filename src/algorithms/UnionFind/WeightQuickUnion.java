package algorithms.UnionFind;

public class WeightQuickUnion {
    private int[] id;
    private int[] size;
    private int count;

    public WeightQuickUnion(int count) {
        this.count = count;
        id = new int[count];
        size = new int[count];
        for (int i=0;i<count;i++){
            id[i] = i;
        }
        for (int i=0;i<count;i++){
            size[i]=1;
        }
    }
    public int find(int point){
        while (point!=id[point]) point = id[point];
        return point;
    }
    public void union(int pointa,int pointb){
        int aRoot = find(pointa);
        int bRoot = find(pointb);
        if (aRoot==bRoot)return;
        if (size[aRoot] < size[bRoot]){
            id[aRoot] = bRoot;
            size[bRoot]+=size[aRoot];
        }
        else {
            id[bRoot] = aRoot;
            size[bRoot]+=size[aRoot];
        }
        count--;

    }
}
