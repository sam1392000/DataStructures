package com.sam.queue;

public class Example_Queue {

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.display();
		System.out.println();
		queue.remove();
		queue.display();
		System.out.println();
		queue.remove();
		queue.display();
		System.out.println();
		queue.remove();
		queue.display();
		//queue.add(6);
		
		

	}

}
