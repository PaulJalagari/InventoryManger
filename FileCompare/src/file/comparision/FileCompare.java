package file.comparision;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileCompare {
	public static void main(String a[]) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the path of the first file");
		Scanner s=new Scanner(new File(sc.next()));
		ArrayList<String> list1=new ArrayList<String>();
		while(s.hasNext()){
			list1.add(s.next().toLowerCase());
		}
		System.out.println("Enter the second file path");
		Scanner s1=new Scanner(new File(sc.next()));
		ArrayList<String> list2=new ArrayList<String>();
		while(s1.hasNext()){
			list2.add(s1.next().toLowerCase());
		}
		ArrayList<String> common = new ArrayList<String>(list1);
		common.retainAll(list2);
		for(int i = 0; i < common.size(); i++){
		    System.out.println(common.get(i));
		}
				}
		}
