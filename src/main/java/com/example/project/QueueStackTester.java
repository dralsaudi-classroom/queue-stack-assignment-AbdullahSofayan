package com.example.project;

public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq)
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Write the recursive static method split that splits a queue of n elements into two
        // queues. The elements with odd orders (i.e. 1st, 3rd, 5th ...) should be put in the
        // first queue and elements with even orders (i.e. 2nd, 4th, 6th ...) should be put in
        // the second queue. The original queue should remain unchanged at the end of the
        // method.
        // Example. Given the queue (A, B, C, D, E), split results in oq (A, C, E), and eq(B, D).
   
    	if(q.length()==0)
    		return;
    	
    	for(int i = 1; i <= q.length(); i++) {
    		 
    		 T data = q.serve();
    		 
    		 if(i % 2 == 0)
    			 eq.enqueue(data);
    		 else
    			 oq.enqueue(data);
    		 
    		 q.enqueue(data);
    		 
    	}
        
        
    }
    public static <T> void remove(LinkedPQ<T> pq, int p)
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Write a static method remove that removes every element in the priority queue
        // having priority less than p.
        // Example. Given pq: [A, 10], [D, 8], [B, 5], [E, 3], [C, 2] remove(pq, 5) results in
        // pq: [A, 10], [D, 8], [B, 5].
    	
    	if(pq.length()==0)
    		return;
    	LinkedPQ<T> tmp = new LinkedPQ<T>();
    	int length = pq.length();
    	for(int i=0 ; i< length; i++) {
    		PQElement<T> e = pq.serve();
    		if(e.p >= p)
    			tmp.enqueue(e.data, e.p); 				
    	}
    	
    	length = tmp.length();
    	
    	for (int i=0; i<length; i++) {
    		PQElement<T> e = tmp.serve();
    		pq.enqueue(e.data, e.p);
    	}
    }
    public static <T> boolean search(Stack<T> st, T e)
    {
       // throw new UnsupportedOperationException("Not supported yet.");
        // Write the recursive static method search that searches for an element e in a stack st
        // and returns true if it’s found or false otherwise. st should not change at the end of
        // the method. You are not allowed to use any auxiliary data structures.
        // Example. Given the stack st (top-to-bottom): 5, 7, 5, 3, 2. search(st, 3) returns
        // true while search(st, 1) returns false.
    	
    	if(st.empty())
    		return false;
    	LinkedStack<T> tmp = new LinkedStack<T>();
    	while(!st.empty()) {
    		T data = st.pop();
    		if(data.equals(e))
    			return true;
    		tmp.push(data);
    	}
    	while (!tmp.empty()) {
    		st.push(tmp.pop());
    	}
    	return false;
    	
    	
    }
}