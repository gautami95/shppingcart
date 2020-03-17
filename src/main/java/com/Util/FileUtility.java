package com.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtility {
 
	//create file
	public void createFile(String filepath){
		File f=new File(filepath);
		try {
			if(f.createNewFile()){
				System.out.println("File got created");
			}else
			{
				System.out.println("File already created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	    
	    //rename file
		public void Renamefile(String source,String Destination){
		File file=new File(source);
		File renemefile=new File(Destination);
		if(file.renameTo(renemefile)){
			System.out.println(" file got rename "+renemefile);
		}else{
			System.out.println("file not rename");
		}
	}
		
		   //copy file(source to destination)
		   public void copyFile(String source,String destination) throws Exception {
			File sourcefile=new File(source);
			File destinationfile=new File(destination);
			
			try {
				System.out.println(" Start "+sourcefile);
				Files.copy(sourcefile.toPath(),destinationfile.toPath() );
				System.out.println(" finish "+destinationfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		   }
		
		 //Zip file path
			
		   public void zipFile(String Sourcefile,String filename,String Destinationfile)throws IndexOutOfBoundsException{
			
				
			byte[] bytesize1=new byte[1024];
			 
			try {
				FileOutputStream fos1 = new FileOutputStream(Sourcefile);
				ZipOutputStream zos=new ZipOutputStream(fos1);
				ZipEntry ze=new ZipEntry(filename);
				zos.putNextEntry(ze);
				FileInputStream fis1=new FileInputStream(Destinationfile);
				
				int z;
				while((z=fis1.read(bytesize1))>0){
					zos.write(bytesize1,0,z);
					}
				
				fis1.close();
				zos.closeEntry();
				zos.close();	
				
				System.out.println("zip file name is Done");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		 	
		   }
		  
		
		//delete all file
		public void Deletefile(String filepath){	
		File file1=new File(filepath);
		if(file1.delete()){
			System.out.println(" file got deleted: " +file1 );
		}else{
			System.out.println("file not deleted");
		}	
		
	}
	}
	


