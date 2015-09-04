package file.comparision;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class ComparingFiles {

	@Test
	public void test() {
		FileCompare file=new FileCompare();
		List<String> list1= new ArrayList<String>();
		list1.add("paul");
		list1.add("jalagari");
		list1.add("test");
		List<String> list2= new ArrayList<String>();
		list2.add("paul");
		list2.add("jalagari");
		 // Create a stream to hold the output
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    PrintStream old = System.out;
	    System.setOut(ps);
	    // Print output: goes to your special stream
	    file.comparingFiles(list1,list2);
	    
	    List<ByteArrayOutputStream> list = Arrays.asList(baos);
	    
		assertEquals(list2,list);
	}

}
