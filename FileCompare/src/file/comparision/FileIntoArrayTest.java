/**
 * 
 */
package file.comparision;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jalagarip
 *
 */
public class FileIntoArrayTest {

	@Test
	public void test() {
		try{FileCompare file=new FileCompare();
		    Scanner directory=new Scanner(System.in);
		    System.out.println("Enter the path");
		    Scanner input = new Scanner(new File(directory.next()));
		    List<String> list = new ArrayList<String>();
		    List<String> expected = new ArrayList<String>();
		    expected.add("paul");
		    expected.add("jalagari");
            file.fileIntoArray(input,list);
            assertEquals(expected,list);
        }
		catch(Exception e){ System.out.println(e);}
	}

}
