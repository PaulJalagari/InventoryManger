package org.first.project;
import java.util.Scanner;
public class simpleSum {
	int sum(int i, int y){return(i+y);}
	public static void main(String args[]){
		simpleSum s= new simpleSum();
		Scanner sc= new Scanner(System.in);
		System.out.println("enter integer values");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int z=s.sum(a,b);
		System.out.println("Sum is"+z);
	}

}
