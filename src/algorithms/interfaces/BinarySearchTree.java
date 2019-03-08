package algorithms.interfaces;

public interface BinarySearchTree {
    int size();

    int get(int key);

    void put(int key, int value);

    Integer min();

    //找到排名为k的键
    int select(int k);

    //返回键的排名
    int rank(int key);
}
