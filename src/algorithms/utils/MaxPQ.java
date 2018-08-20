package algorithms.utils;

public class MaxPQ {
    //可以是无序数组，然后调用delMax的时候用一次冒泡来删除数组结尾的数据
    //可以是有序数组，就是每次插入的时候进行一次排序，然后delMax的时候直接删除最后一位数字
    //书上讲述的是使用二叉堆
    //二叉树的每个节点都大于等于子节点，则成为堆有序，依次来说，每次delMax只要删除根节点即可。
    //这里用数组来实现一个二叉树，则某节点的父节点为i/2,子节点为2*i+1和2*i
    public MaxPQ(){}
    public MaxPQ(int max){}
    public MaxPQ(int[] a){}
    void insert(int v){}
    int max(){
        return 0;
    }
    int delMax(){
        return 0;
    }
    boolean isEmpty(){
        return false;
    }
    int size(){
        return 0;
    }

}
