package com.graphs;

import java.util.*;

public class Graphs_dfs {
	int vertics;
	ArrayList<ArrayList<Integer>>a = new ArrayList<>();
	
	// Constructor to initialize 
	Graphs_dfs(int v)
	{
		this.vertics = v;
		for(int i = 0 ; i < vertics ; i++)
		{
			a.add(new ArrayList<>());
		}
	}
	
	// add the vertices to the graphs
	public void add(int start,int end)
	{
		a.get(start).add(end);
	}
	
	// DFS traversal
	public void dfs_traversal(boolean isvisited[],int index)
	{
		isvisited[index] = true;
		System.out.print(index+" ");
		
		ArrayList<Integer> array = a.get(index);
		for(int i = 0 ; i < array.size() ; i++)
		{
			if(!isvisited[i])
				dfs_traversal(isvisited, i);
		}
		
	}
	
	// DFS INIT
	public void dfs_init(int start)
	{
		boolean isvisited[] = new boolean[vertics];
		dfs_traversal(isvisited,start);
		for(int i = 0 ; i < vertics ; i++)
		{
			if(!isvisited[i])
				dfs_traversal(isvisited,i);
		}
		
	}
	
	// DFS Iterative
	
	public  void dfs_iterative(int start)
	{
		boolean isvisited[] = new boolean[vertics+1];
		
		Stack<Integer>stack = new Stack<>();
		stack.push(start);
		while(!stack.isEmpty())
		{
			start = stack.peek();
			stack.pop();
			
			if(!isvisited[start])
			{
				System.out.print(start+" ");
				isvisited[start] = true;
			}
			Iterator<Integer> it = a.get(start).iterator();
			while(it.hasNext())
			{
				int num = it.next();
				if(isvisited[num] != true)
					stack.push(num);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertices = in.nextInt();
		int no_of_edges = in.nextInt();
		Graphs_dfs g1 = new Graphs_dfs(vertices);
		for(int i = 0 ; i < no_of_edges ; i++)
		{
			int from = in.nextInt();
			int to = in.nextInt();
			g1.add(from, to);
		}
		in.close();
		g1.dfs_init(0);
		System.out.println();
		g1.dfs_iterative(0);
		
	}

}
