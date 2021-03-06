package studentCoursesBackup.driver;

import java.lang.NumberFormatException;
import java.lang.RuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.LinkedHashMap;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.util.Map;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.myTree.Node;

public class Driver {
	
	/**
	 * @param args - command line arguments containing file paths
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		
		String ipFile = null;
		String dlFile = null;
		String opFile1 = null;
		String opFile2 = null;
		String opFile3 = null;
		
		try {
			if(args.length == 5) {
       	        ipFile = args[0];
       	        dlFile = args[1];
	            opFile1 = args[2];
	            opFile2 = args[3];
	            opFile3 = args[4];
			}
			else {
				throw new RuntimeException("Invalid number of arguments. Please enter 5 arguments");
			}
		}
		catch (Exception e) {
			System.err.println(e + " occurred while parsing arguments");
			e.printStackTrace();
			System.exit(0);
		}

		FileProcessor fileP = new FileProcessor(ipFile);
		FileProcessor fp = new FileProcessor(dlFile);

		String dl = null;
		String ip = null;
		int bnumber = 0;
		String course = null;
		ArrayList<String> courses;
		Map<Integer,ArrayList<String>> detail = new LinkedHashMap<Integer,ArrayList<String>>();
		
		Driver dr = new Driver();

		while((ip = fileP.readLine()) != null) {

			try {
				bnumber = Integer.parseInt(ip.substring(0, 4));
				course = ip.substring(5,6);
			}
			catch(Exception e) {
				System.err.println(e + "\nInput file nor formatted properly");
				e.printStackTrace();
				System.exit(0);
			}
				
			if(detail.containsKey(bnumber)) {
				courses = detail.get(bnumber);
				if (!(dr.containString(course, courses))) {
					courses.add(course);
					Collections.sort(courses);
					detail.put(bnumber, courses);
				}
			}
			else {
				courses = new ArrayList<String>();
				courses.add(course);
				detail.put(bnumber, courses);
			}
		}
		
		TreeBuilder tree1 = new TreeBuilder();
		TreeBuilder tree2 = new TreeBuilder();
		TreeBuilder tree3 = new TreeBuilder();
		
		for (int key : detail.keySet()) {
			
			Node node_orig = new Node(key, detail.get(key));
			Node backup_Node_1 = node_orig.clone();
			Node backup_Node_2 = node_orig.clone();
			
			node_orig.registerObserver(backup_Node_1);
			node_orig.registerObserver(backup_Node_2);
			
			tree1.insert(node_orig, key, detail.get(key));
			tree2.insert(backup_Node_1, key, detail.get(key));
			tree3.insert(backup_Node_2, key, detail.get(key));	
		}		
		
		while((dl = fp.readLine()) != null) {
			bnumber = Integer.parseInt(dl.substring(0, 4));
			course = dl.substring(5,6);
			tree1.deleteCourse(bnumber, course);
		}
		
		Results r1 = new Results(opFile1);
		tree1.printNodes(r1);
		r1.writeToFile();
		
		Results r2 = new Results(opFile2);
		tree2.printNodes(r2);
		r2.writeToFile();
		
		Results r3 = new Results(opFile3);
		tree3.printNodes(r3);
		r3.writeToFile();
	}
	
	/**
	 * method to check if arraylist contains string
	 * @param s - string to be checked
	 * @param ar - involved arraylist
	 * @return boolean - True if string found
	 */
	private boolean containString(String s, ArrayList<String> ar) {
		for (String cmp : ar) {
			if (cmp.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
}
