package com.graphs;
import java.util.*;
public class Graphs_BFS {
	int vertices;
	ArrayList<ArrayList<Integer>> bfs = new ArrayList<>();
	
	Graphs_BFS(int v)
	{
		vertices = v;
		for(int i = 0 ; i < v ; i++)
		{
			bfs.add(new ArrayList<>());
		}
	}
	
	public void add(int start , int end)
	{
		bfs.get(start).add(end);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int no_of_vertices = in.nextInt();
		Graphs_BFS g1 = new Graphs_BFS(no_of_vertices);
		int edges = in.nextInt();
		for(int i = 0 ; i < edges ; i++)
		{
			int from = in.nextInt();
			int to = in.nextInt();
			g1.add(from, to);
		}
		g1.bfs_iterative(2);

	}

	private void bfs_iterative(int i) {
		boolean[] isvisited = new boolean[vertices];
		
		Queue<Integer>queue = new LinkedList<>();
		queue.add(i);
		isvisited[i] = true;
		while(!queue.isEmpty())
		{
			int num = queue.peek();
			queue.remove();
			System.out.print(num+" ");
			Iterator<Integer>it = bfs.get(num).iterator();
			while(it.hasNext())
			{
				int val = it.next();
				if(!isvisited[val])
				{
					queue.add(val);
					isvisited[val] = true;
				}
			}
		}
		
	}

}
