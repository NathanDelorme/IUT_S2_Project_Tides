package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Reader {
	private File folder;
	private ArrayList<File> files = new ArrayList<File>();
	
	public Reader() throws Exception {
		folder = new File("data/");
		verifyPath();
		getAllFiles(folder);
		System.out.println(files);
		System.out.println(files.size());
	}
	
	private void verifyPath() throws Exception {
		if(!folder.exists())
			throw new Exception("Reader : " + folder.getName() + " doesn't exist.");
		if(!folder.isDirectory())
			throw new Exception("Reader : " + folder.getName() + " isn't a directory.");
	}
	
	public void getAllFiles(File currentFile) {
		File[] allFiles = currentFile.listFiles();
		
		for(File file : allFiles) {
			
			if(file.isFile()) {
				
				int nameSize = file.getName().length();
				if(nameSize - 4 >= 0) {
					String extension = file.getName().substring(nameSize-4, nameSize);
					
					if(extension.equals(".txt"))
						files.add(file);
				}
			}
			
			else if(file.isDirectory())
				getAllFiles(file);
		}
	}
	
	public void readFile(File file) {
		BufferedReader buffer;
		try {
			buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String currentLine;
			
			while((currentLine = buffer.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(currentLine,"\t");
				
				while (tokens.hasMoreTokens()) {
					String token = tokens.nextToken();
					System.out.print(token + " &&& ");
				}
				
				System.out.println ();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
