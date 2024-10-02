package Entities.Tree;
public interface ITree<T> {
    void insert(T value);
    void remove(T value);
    boolean contains(T value);
}
