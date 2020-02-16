package datastructure.exercise.list;

public interface List<E> {
	public boolean add(int position,E data);
	public E remove(int position);
	public E get(int position);
	public boolean print();
	public int size();
}
