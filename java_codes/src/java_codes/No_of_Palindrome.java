package java_codes;

import java.util.*;

public class No_of_Palindrome {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.next();
		in.close();
		System.out.println(find_permutation(word));

	}
	
	public static int find_permutation(String name)
	{
		ArrayList<String>set = new ArrayList<>();
		for(int i = 0 ; i < name.length() ; i++)
		{
			int start = i;
			int end = i;
			while(start >= 0 && end < name.length())
			{
				if(name.charAt(start) == name.charAt(end))
				{
					String ans = name.substring(start, end+1);
					set.add(ans);
					start--;
					end++;
				}else
				{
					break;
				}	
			}
		}
		
		for(int i = 0 ; i < name.length() ; i++)
		{
			int start = i;
			int end = i+1;
			while(start >= 0 && end < name.length())
			{
				if(name.charAt(start) == name.charAt(end))
				{
					String ans = name.substring(start, end+1);
					set.add(ans);
					start--;
					end++;
				}else
				{
					break;
				}
			}
		}
		System.out.println(set);
		return set.size();
	}

}
