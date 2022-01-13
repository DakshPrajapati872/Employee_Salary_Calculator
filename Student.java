package com.telusko;

public class Student implements java.io.Serializable{
	
	private String Name;
	private int n;
	public Student()
	{
	}
		public void  setName(String Name) {
	
			this.Name=Name;
			
		}
		public String getName() {
			return this.Name;
			
		}
		public void  setn(int n) {
			
			this.n=n;
			
		}
		public int getn() {
			return n*n;
			
		}
	}


