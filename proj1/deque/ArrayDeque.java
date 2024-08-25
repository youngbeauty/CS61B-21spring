package deque;

public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private static final int INITIAL_CAPACITY = 10;

    public int minusOne( int x){
        if(items.length != 0){
            return (x - 1 + items.length) % items.length;
        }
        else return 0;
    }

    public int plusOne( int x){
        if(items.length != 0){
            return (x + 1) % items.length;
        }
        else return 0;
    }

    public void resize(int newSize){
        if (newSize <= 0) {
            throw new IllegalArgumentException("New size must be positive");
        }
        T[] newItems = (T[]) new Object[newSize];
        for(int i = 0; i <size; i ++){
            nextFirst = plusOne(nextFirst);
            newItems[i] = items[nextFirst];
        }
        nextFirst = newSize - 1;
        nextLast = size;
        items = newItems;
    }

    public ArrayDeque(){
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
    }

    public void addLast(T x) {
        if(size == items.length-1){
            resize(size * 2);
        }
        items[nextLast] = x;
        size += 1;
        nextLast = plusOne(nextLast);
    }

    public void addFirst(T x) {
        if(size == items.length){
            resize(size * 2);
        }
        items[nextFirst] = x;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i = 0; i <size - 1; i ++){
            plusOne(nextFirst);
            System.out.print(items[nextFirst] + " ");
        }
        System.out.print("\n");
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T remove = items[nextFirst];
        size -= 1;
        if(size< items.length* 3 / 4){
            resize(size + 1);
        }
        return remove;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        if(size< items.length* 3 / 4){
            resize(size + 1);
        }
        nextLast = minusOne(nextLast);
        T remove = items[nextLast];
        size -= 1;
        return remove;
    }

    public T get(int index){
        if(index > size - 1){
            return null;
        }
        int get = nextFirst;
        for(int i = -1; i < index;i++){
            get = plusOne(get);
        }
        return items[get];
    }






}
