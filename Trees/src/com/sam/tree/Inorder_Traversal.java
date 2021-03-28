package com.sam.tree;

import java.util.*;

class Tree_functions
{
	// Level Wise insertion
	public Tree level_wise_insertion(String input)
	{
		String input_array[] = input.split(" ");
		int index = 1;
		Queue<Tree> queue = new LinkedList<>();
		int val = Integer.parseInt(input_array[0]);
		Tree head = new Tree(val);
		queue.add(head);
		
		while(index < input_array.length && !queue.isEmpty())
		{
			Tree root = queue.peek();
			queue.remove();
			
			String value = input_array[index];
			if(!value.equals("N"))
			{
				root.left = new Tree(Integer.parseInt(value));
				queue.add(root.left);
			}
			index++;
			if(index >= input_array.length)
				break;
			value = input_array[index];
			if(!value.equals("N"))
			{
				root.right = new Tree(Integer.parseInt(value));
				queue.add(root.right);
			}
			index++;
			if(index >= input_array.length)
				break;
		}
		
		return head;
	}

	public void inorder_recursive(Tree head)
	{
		if(head == null)
			 return;
		inorder_recursive(head.left);
		System.out.print(head.data+" ");
		inorder_recursive(head.right);
	}

	public void inorder_iterative(Tree head)
	{
		Tree curr = head;
		Stack<Tree> stack = new Stack<>();
		while(!stack.isEmpty() || curr != null)
		{
			while(curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			Tree last = stack.pop();
			System.out.print(last.data+" ");
			curr = last.right;
		}
	}

	public void pre_order_recursive(Tree head)
	{
		if(head == null)
			return;
		System.out.print(head.data+" ");
		pre_order_recursive(head.left);
		pre_order_recursive(head.right);
	}

	public void pre_order_iterative(Tree head)
	{
		Tree curr = head;
		Stack<Tree> stack = new Stack<>();
		while(curr != null || !stack.isEmpty())
		{
			while(curr != null)
			{
				stack.push(curr);
				System.out.print(curr.data+" ");
				curr = curr.left;
			}
			Tree last = stack.pop();
			curr = last.right;
		}
	}

	public void postorder_recursive(Tree head)
	{
		if(head == null)
			return;
		postorder_recursive(head.left);
		postorder_recursive(head.right);
		System.out.print(head.data+" ");
	}

	public void postorder_iterative(Tree head)
	{
		Stack<Tree>stack1 = new Stack<>();
		Stack<Tree>stack2 = new Stack<>();
		stack1.push(head);
		while(!stack1.isEmpty())
		{
			Tree temp = stack1.pop();
			stack2.push(temp);
			if(temp.left != null)
				stack1.push(temp.left);
			if(temp.right != null)
				stack1.push(temp.right);
		}
		while(!stack2.isEmpty())
		{
			System.out.print(stack2.pop().data+" ");
		}
	}
}

public class Inorder_Traversal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		Tree_functions t1 = new Tree_functions();
		Tree root = t1.level_wise_insertion(input);
		System.out.println("Inorder Traversal using recursion");
		t1.inorder_recursive(root);
		System.out.println();
		System.out.println("Inorder Traversal using Iterative");
		t1.inorder_iterative(root);
		System.out.println();
		System.out.println("PreOrder Traversal using Recursive");
		t1.pre_order_recursive(root);
		System.out.println();
		System.out.println("Preorder Traversal using Iterative");
		t1.pre_order_iterative(root);
		System.out.println();
		System.out.println("postorder Traversal using Recursive");
		t1.postorder_recursive(root);
		System.out.println();
		System.out.println("Postorder Traversal using Iterative");
		t1.postorder_iterative(root);
		
		

	}

}

/*
 * 
 * Input:  1 2 3 N 5 6 7 N 8
 * 
 * Output
	Inorder Traversal using recursion
	2 5 8 1 6 3 7 
	Inorder Traversal using Iterative
	2 5 8 1 6 3 7 
	PreOrder Traversal using Recursive
	1 2 5 8 3 6 7 
	Preorder Traversal using Iterative
	1 2 5 8 3 6 7 
	postorder Traversal using Recursive
	8 5 2 6 7 3 1 
	Postorder Traversal using Iterative
	8 5 2 6 7 3 1 
 * 
 * 
 * 
 * 
 * */
