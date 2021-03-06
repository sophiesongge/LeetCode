package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sophie Song
 * @since 07/07/2017
 */
public class stackFromQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /**
     * Constructor
     */
    public stackFromQueue(){
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /**
     * Push an element to the stack
     * @param a
     */
    public synchronized void push(int a) throws InterruptedException {
        if(q1.isEmpty()){
            q1.add(a);
            while(!q2.isEmpty()){
                q1.add(q2.poll());
            }
        }else{
            q2.add(a);
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
        }

    }

    /**
     * Show the top element in the stack
     * @return
     */
    public synchronized int peek() throws InterruptedException {
        try{
            return q1.isEmpty() ? q2.peek() : q1.peek();
        }catch (NullPointerException e){
            System.out.println("The Stack is empty, can not peek.");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Show the top element in the stack, and delete it from the stack
     * @return
     */
    public synchronized int pop() throws InterruptedException {
        try{
            return q1.isEmpty() ? q2.poll() : q1.poll();
        }catch (NullPointerException e) {
            System.out.println("The Stack is empty, can not poll.");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Return whether the stack is empty
     * @return
     */
    public boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty();
    }

}

