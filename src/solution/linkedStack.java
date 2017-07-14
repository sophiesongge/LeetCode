package solution;

/**
 * @author Sophie
 * @since 14/07/2017
 */

public class linkedStack<T> {
    private class Node<T> {
        T val;
        Node<T> next;

        Node(){
            val = null;
            next = null;
        }

        Node(T val, Node next){
            this.val = val;
            this.next = next;
        }

        boolean isEnd() {
            return this.val == null && this.next == null;
        }
    }

    private Node<T> head = new Node();

    public void push(T item) {
        head = new Node(item, head);
    }

    public T pop(){
        T result = head.val;
        if(!head.isEnd()) {
            head = head.next;
        }
        return result;
    }

    public T peek() {
        return head.val;
    }

    public boolean isEmpty(){
        return head.isEnd();
    }
}
