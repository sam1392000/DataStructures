package com.sam.queue;

public class CircularQueue {

	public static void main(String[] args) {
		Queue cqueue = new Queue(5);
		cqueue.cc_insertion(10);
		cqueue.cc_insertion(20);
		cqueue.cc_insertion(30);
		cqueue.cc_insertion(40);
		cqueue.cc_insertion(50);
		cqueue.display();
		System.out.println();
		cqueue.cc_deletion();
		cqueue.display();
		System.out.println();
		cqueue.cc_deletion();
		cqueue.display();
		System.out.println();
		cqueue.cc_insertion(60);
		cqueue.disp();
		cqueue.cc_deletion();
		
		cqueue.disp();


	}

}
