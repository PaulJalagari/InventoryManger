package file.comparision;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileCompare {
	public static void main(String a[]) throws Exception {
		FileCompare fc=new FileCompare();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path of the first file");
		Scanner s = new Scanner(new File(sc.next()));
		ArrayList<String> list1 = new ArrayList<String>();
		fc.fileIntoArray(s,list1);
		System.out.println("Enter the second file path");
		Scanner s1 = new Scanner(new File(sc.next()));
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> common = new ArrayList<String>(list1);
		fc.fileIntoArray(s1,list2);
		common.retainAll(list2);
		for (int i = 0; i < common.size(); i++) {
			System.out.println(common.get(i));
		}
	}
	private void fileIntoArray(Scanner sc1, ArrayList<String> l){
		while (sc1.hasNext()) {
			l.add(sc1.next().toLowerCase());
		}
	}
}
