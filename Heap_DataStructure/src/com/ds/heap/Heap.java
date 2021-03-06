package com.ds.heap;
import java.util.*;
public class Heap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int array[] = new int[size];
		for(int i = 0 ; i < size ; i++)
		{
			array[i] = in.nextInt();
			heapify(array , i);
		}
		
		// deletion is min heap
		delete_elements(array);
		
		// print the array
		for(int i = 0 ; i < size ; i++)
		{
			System.out.print(array[i]+" ");
		}

	}
	
	/*For max heap only change the comparison operator in while loop 
	 *       while(child > 0 && array[child] > array[parent])
	 *       {
	 *       	.....rest is same as min-heap
	 *       }
	 * 
	 * */
	
	

	// Insertion of Min heap 
	private static void heapify(int[] array, int i) {
		int child = i;    // child Node
		int parent = (i-1)/2;   // Parent Node
		while(child > 0 && array[child] < array[parent]) // if parent is greater than child swap those elements
		{
			int temp = array[child];
			array[child] = array[parent];
			array[parent]= temp;
			child = parent;
			parent = (child-1)/2;
		}
	}
	
	// deletion in min heap
	

	private static void delete_elements(int []array) {
		int first = array[0];
		
		
	}

}
