package com.sam.queue;
public class Queue {
	int array[];
	int rear;
	int front;
	int size;
	
	Queue(int size)
	{
		this.size = size;
		array = new int[size];
		front = -1;
		rear = -1;
	}
	
	public void add(int number) // linear Queue
	{
		if(isFull())
		{
			System.out.println("Queue is full");
		}
		else if(isEmpty())
		{
			front = 0;
			rear = 0;
			array[rear] = number;
		}
		else
		{
			rear++;
			array[rear] = number;
		}
	}
	
	public void remove() // linear queue
	{
		if(!isEmpty())
		{
			System.out.println("The Element "+array[front]+" is Deleted successfully");
			front++;
		}
	}
	
	public boolean isFull() // linear Queue
	{
		if(rear == size)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() // linear Queue
	{
		if(rear == -1 && front == -1)
		{
			return true;
		}
		return false;
	}
	
	public void display()// linear Queue
	{
		int i = front;
		while(i <= rear )
		{
			System.out.print(array[i]+" ");
			i++;
		}
	}
	
	
	
	/*
	 * Circular Queue insertion and deletion
	 * 
	 * full condition  => ((rear+1)% size = front);
	 * empty condition => (rear == -1 && front == -1)
	 * 
	 * */
	
	public void cc_insertion(int data)
	{
		if(isccFull())
		{
			System.out.println("The QUEUE is Full");
		}
		else if(isccEmpty())
		{
			front = 0; 
			rear = 0;
			array[rear] = data;
			System.out.println(data+" is added in the position "+rear);
		}
		else {
			rear = (rear+1) % size;
			array[rear] = data;
			System.out.println(data+" is added in the position "+rear);
		}
	}
	
	public void cc_deletion()
	{
		if(isccEmpty())
		{
			System.out.println("The QUEUE is Empty");
		}
		else if(front == rear)
		{
			int x = array[front];
			front = -1;
			rear = -1;
			System.out.println(x+ "has been deleted");
		}
		else
		{
			int x = array[front];
			front = (front+1)%size;
			System.out.println(x+" is deleted");
		}
	}
	
	public boolean isccFull()
	{
		if((rear+1)%size == front)
		{
			return true;
		}
		return false;
	}
	
	public boolean isccEmpty()

	{
		if(front == -1 && rear == -1)
			return true;
		return false;
	}
	
	
	public void disp()
	{
//		System.out.println("front "+front+" "+array[front]);
//		System.out.println("rear "+rear+" "+array[rear]);
//		System.out.println(size);
		int i;
		for(i = front ; i != rear ; i = (i+1) % size)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println(array[i]);
		System.out.println();
	}
}
