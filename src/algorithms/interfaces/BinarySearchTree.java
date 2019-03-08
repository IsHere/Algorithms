package algorithms.interfaces;

public interface BinarySearchTree {
    int size();

    int get(int key);

    void put(int key, int value);

    Integer min();

    //�ҵ�����Ϊk�ļ�
    int select(int k);

    //���ؼ�������
    int rank(int key);
}
