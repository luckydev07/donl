package org.donl.task;

import java.util.*;
import java.io.*;
public class ScriptPrep{
    String dir;
    int num;
    ArrayList video = new ArrayList();
    Scanner in = new Scanner(System.in);
    
    public void ask(){
	System.out.print("Enter the directory to store the Videos:");
	dir = in.next();
	System.out.print("Enter the number of videos:");
	num=in.nextInt();
	
	for(int i=1;i<=num;i++){
	    System.out.print("Enter the video url "+i+":");
	    video.add(in.next());
	}

    }

    public void gen(){
	String dirLine = "mkdir ~/Videos/"+dir;
	try{
	    FileWriter fw = new FileWriter("/home/lakshmanan/download.sh");
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(dirLine);
	    
	    for(int j=1;j<=num;j++){
		bw.newLine();
		String line="youtube-dl -o ~/Videos/"+dir+"/part"+j+".flv "+video.get(j-1);
		bw.write(line);
		bw.newLine();
		bw.write("echo Part "+j+" over");
		bw.flush();
	    }
	    System.out.println("Script generated");
	    System.out.println("See under your home directory for the file download.sh");
	    System.out.println("Now run the download.sh  by giving    sh download.sh");
	}catch(Exception e){
		System.out.println("Error");
	}
    }
}