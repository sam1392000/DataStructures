package com.sam.tree;

import java.util.*;

class level
{
	int stage;
	Tree node;
	level(int stage , Tree node)
	{
		this.stage = stage;
		this.node = node;
	}
}

class Views
{
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

	public void inorder(Tree head)
	{
		Stack<Tree>stack = new Stack<>();
		//stack.add(head);
		Tree curr = head;
		while(!stack.isEmpty() || curr != null)
		{
			while(curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			Tree temp = stack.pop();
			System.out.print(temp.data+" ");
			curr = temp.right;
			
		}
	}

	public void rightView(Tree head)
	{
		Queue<Tree> queue = new LinkedList<>();
		queue.add(head);
		ArrayList<Integer>ans = new ArrayList<>();
		while(!queue.isEmpty())
		{
			int size = queue.size();
			ArrayList<Integer>array = new ArrayList<>();
			while(size-- > 0)
			{
				Tree temp = queue.peek();
				queue.remove();
				array.add(temp.data);
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
			ans.add(array.get(array.size()-1));
		}
		System.out.println("Right View "+ans);
	}

	public void leftView(Tree head)
	{
		Queue<Tree> queue = new LinkedList<>();
		queue.add(head);
		ArrayList<Integer>ans = new ArrayList<>();
		while(!queue.isEmpty())
		{
			int size = queue.size();
			ArrayList<Integer>array = new ArrayList<>();
			while(size-- > 0)
			{
				Tree temp = queue.peek();
				queue.remove();
				array.add(temp.data);
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
			ans.add(array.get(0));
		}
		System.out.println("Left View "+ans);
	}
	
	public void topView(Tree head)
	{
		TreeMap<Integer,ArrayList<Integer>>tmap = new TreeMap<>();
		Queue<level>queue = new LinkedList<>();
		queue.add(new level(0 , head));
		while(!queue.isEmpty())
		{
			int size = queue.size();
			while(size-- > 0)
			{
				level temp = queue.peek();
				queue.remove();
				Tree just = temp.node;
				int level = temp.stage;
				
				if(tmap.containsKey(level) == false)
				{
					ArrayList<Integer>a= new ArrayList<>();
					a.add(just.data);
					tmap.put(level, a);
				}else
				{
					tmap.get(level).add(just.data);
				}
				
				if(just.left != null)
				{
					queue.add(new level(level-1 , just.left));
				}
				if(just.right != null)
				{
					queue.add(new level(level+1 , just.right));
				}
			}
		}
		ArrayList<Integer>ans = new ArrayList<>();
		for(Map.Entry<Integer,ArrayList<Integer>>map:tmap.entrySet())
		{
		    ArrayList<Integer>a = map.getValue();
		    ans.add(a.get(0));
		}
		System.out.println("Top View "+ans);
	}

	public void bottomView(Tree head)
	{
		TreeMap<Integer,ArrayList<Integer>>tmap = new TreeMap<>();
		Queue<level>queue = new LinkedList<>();
		queue.add(new level(0 , head));
		while(!queue.isEmpty())
		{
			int size = queue.size();
			while(size-- > 0)
			{
				level temp = queue.peek();
				queue.remove();
				Tree just = temp.node;
				int level = temp.stage;
				
				if(tmap.containsKey(level) == false)
				{
					ArrayList<Integer>a= new ArrayList<>();
					a.add(just.data);
					tmap.put(level, a);
				}else
				{
					tmap.get(level).add(just.data);
				}
				
				if(just.left != null)
				{
					queue.add(new level(level-1 , just.left));
				}
				if(just.right != null)
				{
					queue.add(new level(level+1 , just.right));
				}
			}
		}
		ArrayList<Integer>ans = new ArrayList<>();
		for(Map.Entry<Integer,ArrayList<Integer>>map:tmap.entrySet())
		{
		    ArrayList<Integer>a = map.getValue();
		    ans.add(a.get(a.size()-1));
		}
		System.out.println("Bottom View "+ans);
	}
}

public class View_in_binarytree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		Views v1 = new Views();
		Tree root = v1.level_wise_insertion(input);
		v1.inorder(root);
		System.out.println();
		v1.rightView(root);
		v1.leftView(root);
		v1.topView(root);
		v1.bottomView(root);
		
	}

}

/*
 * 	10 20 30 40 60 90 100
	40 20 60 10 90 30 100 
	Right View [10, 30, 100]
	Left View [10, 20, 40]
	Top View [40, 20, 10, 30, 100]
	Bottom View [40, 20, 90, 30, 100]
 * 
 * 
 * Top view means -> Level order traversal in arraylist first element
 * Bottom View means -> Level order traversal in arraylist last element
 * 
 * 
 * */
