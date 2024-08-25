package deque;

public class LinkedListDeque<T> {
    public void printDeque() {
        int count = 0;
        StuffNode firstNode = sentinel.back;
        for(count = 0;count < size;count ++){
            System.out.print(firstNode.stuff + " ");
            firstNode = firstNode.back;
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        if (size == 0){
            return null;
        }
        StuffNode firstNode = sentinel.back;
        if (size == 1) {
            sentinel.back = null;
            sentinel.prev = null;
        } else {
            sentinel.back = firstNode.back;
            firstNode.back.prev = sentinel;
        }
        size -= 1;
        return firstNode.stuff;
    }

    private class StuffNode{
        public StuffNode prev;
        public StuffNode back;
        public T  stuff;
        public StuffNode(T s,StuffNode n1,StuffNode n2){
            prev = n1;
            back = n2;
            stuff = s;
        }
    } ;

    private int size;
    private StuffNode sentinel;
    public LinkedListDeque(){
        sentinel = new StuffNode((T) "Sentinel",null,null);
        size = 0;
    }

    public void addFirst(T item){
        StuffNode newNode = new StuffNode(item,sentinel,sentinel.back);
        if (size == 0){
            sentinel.back = newNode;
            sentinel.prev = newNode;
        }else {
            sentinel.back.prev = newNode;
            sentinel.back = newNode;
        }
        size += 1;
    }

    public void addLast(T item){
        if (size == 0){
            StuffNode newNode = new StuffNode(item,sentinel,sentinel);
            sentinel.back = newNode;
            sentinel.prev = newNode;
        }else{
            StuffNode newNode = new StuffNode(item,sentinel.prev,sentinel);
            sentinel.prev.back = newNode;
            sentinel.prev = newNode;
        }
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public T removeLast(){
        if (size == 0){
            return null;
        }
        StuffNode lastNode = sentinel.prev;
        if (size == 1) {
            sentinel.back = null;
            sentinel.prev = null;
        } else {
            lastNode.prev.back = sentinel;
            sentinel.prev = lastNode.prev;
        }
        size -= 1;
        return lastNode.stuff;
    }

    public T get(int index){
        if (index < 0 || index >= size){
            return null;
        }else {
            StuffNode firstNode = sentinel.back;
            for(int count = 0;count < index - 1;count ++){
                firstNode = firstNode.back;
            }
            return firstNode.stuff;
        }
    }

    public T getRecursive(int index){
        StuffNode firstNode = sentinel.back;
        if (index < 0 || index >= size){
            return null;
        }else if(index == 0) {
            return firstNode.stuff;
        }else {
            firstNode = firstNode.back;
            index -= 1;
            return getRecursive(index);
        }
    }

}
