package pricewatcher;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ItemManager {
	private int size;

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String[] InitialItems(String fileName, int info)throws IOException {

		File inputFile = new File (fileName);
	    Scanner sc = new Scanner (inputFile);

	    String[] fileArray = new String [info];

	    while(sc.hasNextLine()){
	    	String line	= sc.nextLine();
	        String cut = "[,]";
	        String[] cell = line.split(cut);

	        for(int i=0; i<cell.length;i++){
	        	fileArray[i] = cell[i];
	            }
	        }
	    	
	    return fileArray;
	    }

	public void deleteItem(String fileName, int info, String item)throws IOException{
		File inputFile = new File (fileName);
	    Scanner sc = new Scanner (inputFile);

	    String[] fileArray = new String [info];

	    while(sc.hasNextLine()){
	    	String line	= sc.nextLine();
	        String cut = "[,]";
	        String[] cell = line.split(cut);

	        for(int i=0; i<cell.length;i++){
	        	
	        	fileArray[i] = cell[i];
	            }
	        }
		
	}
}
