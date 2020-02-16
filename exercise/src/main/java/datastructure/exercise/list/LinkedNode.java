package datastructure.exercise.list;

public class LinkedNode<T> {
    public T data;
    public LinkedNode<T> next;

    public LinkedNode() {
    }

    public LinkedNode(T data) {
        this.data = data;
        this.next = null;
    }
}
