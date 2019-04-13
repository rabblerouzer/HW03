package pricewatcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class checkManageItems {
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

	public static void deleteItem(String fileName, Item item)throws IOException{
		File inputFile = new File (fileName);
	    Scanner sc = new Scanner (inputFile);


	    while(sc.hasNextLine()){
	    	String line	= sc.nextLine();
	        String cut = "[,]";
	        String[] cell = line.split(cut);
	        String[] wordArray = new String[7];
	        for(int i=0; i<cell.length;i++){
	        	wordArray[i] = cell[i];
	        }
	        if (wordArray[1].contentEquals(item.url)) {
	        	
	        }else {
	        	FileWriter fw;
	            fw = new FileWriter(new File("fileName.txt"));
	            fw.write(String.format(line));
	        	fw.write(System.lineSeparator());
	        }
	    }
		
	}
	public static void addItem(Item item, String fileName, int info) throws IOException {
		
		File inputFile = new File (fileName);
	    Scanner sc = new Scanner (inputFile);

	    String[] fileArray = new String [info];
	    int counter = 0; 
	    while(sc.hasNextLine()){
	    	String line	= sc.nextLine();
	        fileArray[counter] = line;
	        counter++;
	        System.out.println(counter);
	    }
	    System.out.println(counter);
	    
	    FileWriter fw;
	    
	    fw = new FileWriter(new File("C:\\Users\\edgar\\eclipse-workspace\\homework2EscobedoEdgarJorgeQuinonez\\fileName.txt"));
        
        
	    
        for(int i = 0; i < counter; i++) {
        	fw.write(String.format(fileArray[i]));
        	fw.write(System.lineSeparator());
        }
             
        fw.write(String.format(item.name+","));
            
        fw.write(String.format(item.url+","));
   
        fw.write(String.format(item.initialPrice,","));
            
        fw.write(String.format(item.currentPrice+","));
            
        fw.write(String.format(item.change+","));
   
        fw.write(String.format(item.date,","));
            
            
        fw.write(System.lineSeparator()); //new line
        fw.close();
	}
	public static void eraseFile() throws IOException {
		FileWriter fw;
		fw = new FileWriter(new File("C:\\Users\\edgar\\eclipse-workspace\\homework2EscobedoEdgarJorgeQuinonez\\fileName.txt"));
		
		//writer.print("");
		//writer.close();
	}
	public static void finalItems(String fileName, int info) throws IOException {
		File inputFile = new File (fileName);
	    Scanner sc = new Scanner (inputFile);

	    String[] fileArray = new String [info];
	    int counter = 0; 
	    while(sc.hasNextLine()){
	    	String line	= sc.nextLine();
	        fileArray[counter] = line;
	        System.out.println(fileArray[counter]);
	        counter++;
	        System.out.println(counter);
	    }
	    System.out.println(counter);
	    
	    FileWriter fw2;
	    eraseFile();
	    fw2 = new FileWriter(new File("C:\\Users\\edgar\\eclipse-workspace\\homework2EscobedoEdgarJorgeQuinonez\\fileName"));
	    fw2.close();
	    FileWriter fwFinal;
	   
	    fwFinal = new FileWriter(new File("fileNameFinal.txt"));
        
        
	    
        for(int i = 0; i < counter; i++) {
        	fwFinal.write(String.format(fileArray[i]));
        	fwFinal.write(System.lineSeparator());
        }
        fwFinal.close();
        
		
	}
	/*************************************
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void adItem(String fileName, Item item) {
		try
		{
		    String filename= "MyFile.txt";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(System.lineSeparator());
		    fw.write(item.name+","+item.url+","+item.initialPrice+","+item.currentPrice+","+item.change+","+item.date);//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	public static void seeItems(String fileName) throws IOException {
		File file = new File(fileName); 
		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		String st; 
		while ((st = br.readLine()) != null) 
			System.out.println(st);
	}
	public static void changeItemName(String fileName, Item item, String name) throws IOException {
		File inputFile = new File (fileName);
        Scanner sc = new Scanner (inputFile);

        String[] info = new String[1000];
        int counter = 0;
        while(sc.hasNextLine()){
            String line	= sc.nextLine();
            String cut = "[,]";
            String[] cell = line.split(cut);
            if ( cell[0].equals(item.name)){
            	System.out.println(counter);
            	info[counter] = name+","+cell[1]+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
            }else {
            	info[counter] = cell[0]+","+cell[1]+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
            }
            
            counter++;
        }
	    FileWriter fwFinal;
	    fwFinal = new FileWriter(new File("myFile.txt"));
        for(int i = 0; i < counter; i++) {
        	fwFinal.write(String.format(info[i]));
        	fwFinal.write(System.lineSeparator());
        }
        fwFinal.close();	
	}
	public static void changeItemURL(String fileName, Item item, String url) throws IOException {
		File inputFile = new File (fileName);
        Scanner sc = new Scanner (inputFile);

        String[] info = new String[1000];
        int counter = 0;
        while(sc.hasNextLine()){
            String line	= sc.nextLine();
            String cut = "[,]";
            String[] cell = line.split(cut);
            if ( cell[1].equals(item.url)){
            	System.out.println(counter);
            	info[counter] = cell[0]+","+url+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
            }else {
            	info[counter] = cell[0]+","+cell[1]+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
            }
            
            counter++;
        }
	    FileWriter fwFinal;
	    fwFinal = new FileWriter(new File("myFile.txt"));
        for(int i = 0; i < counter; i++) {
        	fwFinal.write(String.format(info[i]));
        	fwFinal.write(System.lineSeparator());
        }
        fwFinal.close();	
	}
	public static void deleteItem(String fileName, Item item, String name, String url) throws IOException {
		File inputFile = new File (fileName);
        Scanner sc = new Scanner (inputFile);

        String[] info = new String[1000];
        int counter = 0;
        while(sc.hasNextLine()){
            String line	= sc.nextLine();
            String cut = "[,]";
            String[] cell = line.split(cut);
            if ( cell[0].equals(name) && cell[1].equals(url)){
            }else {
            	info[counter] = cell[0]+","+cell[1]+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
            	counter++;
            }
        }
	    FileWriter fwFinal;
	    fwFinal = new FileWriter(new File("myFile.txt"));
        for(int i = 0; i < counter; i++) {
        	fwFinal.write(String.format(info[i]));
        	fwFinal.write(System.lineSeparator());
        }
        fwFinal.close();	
	}
	
	public static void main(String[] args) throws IOException {
		
		File inputFile = new File ("fileName.txt");
	    Scanner sc = new Scanner (inputFile);
	    Scanner scan = new Scanner(System.in);
	    int counter = 1000; 
	    System.out.println("Please select an option");
	    System.out.println("1: see items");
	    System.out.println("2: add item");
	    System.out.println("3: delete item");
	    System.out.println("4: change existing item name");
	    System.out.println("5: change existing item url");
	    System.out.println("6: delete item");
	    System.out.println("7: exit");
	    
	    int option = scan.nextInt();
	    Item item4 = new Item("name4", "url4", "4", 4 , "4", 1, "0");
	    Item item2 = new Item("name2", "url2", "2", 2 , "2", 2, "0");
	    while(option != 7) {
		    switch(option) {
		    	case 1: option = 1;
		    		seeItems("myFile.txt");
		    		System.out.println("Select an option:");
		    		option = scan.nextInt();
		    		break;
		    	case 2: option = 2;
		    		adItem("myFile.txt", item4);
		    		System.out.println("Select an option:");
		    		option = scan.nextInt();
		    		break;
		    	case 3: option = 3;
		    		//delete Item
		    		break;
		    	case 4: option = 4;
		    		changeItemName("myFile.txt", item2, "new name");
		    		System.out.println("Select an option:");
		    		option = scan.nextInt();
		    		break;
		    	case 5: option = 5;
	    			changeItemURL("myFile.txt", item2, "new url");
	    			System.out.println("Select an option:");
	    			option = scan.nextInt();
	    			break;
		    	case 6: option = 6;
		    		System.out.println("Select the name of the file to be erased");
		    		String name = scan.next();
		    		System.out.println("Select the url of the file to be erased");
		    		String url = scan.next();
		    		
    				deleteItem("myFile.txt", item2, name, url);
    				System.out.println("Select an option:");
    				option = scan.nextInt();
    				break;
		    	default:
		    		System.out.println("Wrong input, select an option:");
		    		option = scan.nextInt();
		    		break;
		    	
		    }
	    }
	}
}

