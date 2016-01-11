package irishrail.sample.com.irishrailrealtime.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils {
	
	public static void saveFile(Context context,String filename,String content){
	
		try {
			File f=new File(filename); 
			FileOutputStream outputStream;
			
			if(!f.exists()){
				buildDirectory(context,filename);
			}
			outputStream = new FileOutputStream (f);
			outputStream.write(content.getBytes());
			outputStream.close();
		} catch (FileNotFoundException e) {
		  e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readFile(String filename){
		FileInputStream fis=null;
		String content=null;
		try {
			fis = new FileInputStream (new File(filename)); 
			//fis = context.openFileInput( filename);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bufferedReader = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			content=sb.toString();
			if(bufferedReader!=null){
				bufferedReader.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return content;
		
	}

	/**
	 * utility to delete a directory - we have to do this recurively on Android, 
	 * unfortunately as we can't delete a dir if it has children
	 * */
	public static void deleteRecursive(File fileOrDirectory) {

	    if (fileOrDirectory.isDirectory()){

	        for (File child : fileOrDirectory.listFiles()){
	        	deleteRecursive(child);
	        }
	    }
	    fileOrDirectory.delete();
	}
	
	public static void buildDirectory(Context context,String path){
		
		
		String dirs=path.replaceAll(context.getFilesDir().toString(),"");
		String[] temp=dirs.split("/");
		
		int len=temp.length-1; //we leave out the leaf node because it's the file
		
		String tempPath=context.getFilesDir().toString();
		
		for(int i=0;i<(len);i++){
			tempPath+="/";
			tempPath+=temp[i];
		}
		
		File folder =new File(tempPath);
		folder.mkdirs();
		
		
	}
}
