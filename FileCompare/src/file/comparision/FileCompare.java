package file.comparision;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class FileCompare {
	public static void main(String a[]) throws Exception {
		FileCompare fc = new FileCompare();
		Scanner path = new Scanner(System.in);
		System.out.println("Enter the path of the first file");
		Scanner read1 = new Scanner(new File(path.next()));
		List<String> text1 = new ArrayList<String>();
		fc.fileIntoArray(read1, text1);
		System.out.println("Enter the second file path");
		Scanner read2 = new Scanner(new File(path.next()));
		List<String> text2 = new ArrayList<String>();
		fc.fileIntoArray(read2, text2);
		fc.comparingFiles(text1, text2);
	}

	public void fileIntoArray(Scanner read, List<String> text) {
		while (read.hasNext()) {
			text.add(read.next().toLowerCase());
		}
	}

	public void comparingFiles(List<String> compare, List<String> compareto) {
		List<String> common = new ArrayList<String>(compare);
		common.retainAll(compareto);
		for (int i = 0; i < common.size(); i++) {
			System.out.println(common.get(i));
		}

	}
}