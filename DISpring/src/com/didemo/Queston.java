package com.didemo;

import java.util.Iterator;
import java.util.List;

public class Queston {
	
	private int id;
	private String que;
	private List<String> answer;
	
	public Queston(int id, String que, List<String> answer) {
		super();
		this.id = id;
		this.que = que;
		this.answer = answer;
	}
	
	public void display()
	{
		System.out.println("Id : "+id);
		System.out.println("Que : "+que);
		System.out.println("Answer : ");
		
		Iterator<String> itr=answer.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

}
