package com.sam.tree;
import java.util.*;
public class Height_diameter {

	public static int height(Tree head) // Height 
	{
		if(head == null)
			return 0;
		int left = height(head.left);
		int right = height(head.right);
		return Integer.max(left, right)+1;
	}
	
	public static int diameter(Tree head)
	{
		if(head == null)
			return 0;
		int lf = height(head.left);
		int rf = height(head.right);
		int ldia = diameter(head.left);
		int rdia = diameter(head.right);
		int fd = Integer.max(lf+rf, Integer.max(ldia, rdia));
		return fd;
		
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		Tree_functions t1 = new Tree_functions();
		Tree head = t1.level_wise_insertion(input);
		System.out.println("Height "+height(head));
		System.out.println("Diameter "+diameter(head));

	}

}
// 10 20 30 40 60 90 100
