package fileHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class LFile2 {

	private File f;
	private Scanner s;
	public String[] string = new String[1000];
	private int p;
	
	public LFile2(File file){
		f = file;
	}
	
	public void create() throws IOException{
			f.createNewFile();
	}
	
	public String[] open(boolean ignoreEmpty)  throws IOException {
		if(ignoreEmpty){ 
			s = new Scanner(this.f);
			for(int i = 1; s.hasNext(); ){
				string[i] = new String();
				string[i] = s.next();
				if(string[i].substring(0, 2) != null && !string[i].substring(0, 2).equals("##")){
					i++;
				}
				else{
					s.nextLine();
				}
			}
				s.close();
		}
		else{ 	
			s = new Scanner(this.f);
			for(int i = 1; s.hasNext(); i++){
				string[i] = new String();
				string[i] = s.next();
			}
				s.close();
		}
		return string;
	}
	
	public void append(String txt){
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(f, true));
				out.append(txt + System.getProperty("line.separator"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public File getFile() {
		return f;
	}
	
	public void Copy(File to) throws IOException{
			Files.copy( f.toPath(), to.toPath() );
	}
	
	public void close(){
		s.close();
	}
	
	public String GetOpenPath(){
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		filechooser.setAcceptAllFileFilterUsed(false);
		filechooser.setApproveButtonToolTipText("Open");
		p = filechooser.showOpenDialog(null);
		if(p == 0){
			return filechooser.getSelectedFile().getAbsolutePath();
		}
		else{return null;}
	}
	
	public String GetSafePath(){
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		filechooser.setAcceptAllFileFilterUsed(false);
		filechooser.setDialogType(JFileChooser.SAVE_DIALOG);
		p = filechooser.showSaveDialog(null);
		if(p == 0){
			return filechooser.getSelectedFile().getAbsolutePath();
		}
		return null;
	}
	
	public boolean exist(){
		if(f.exists()){
			return true;
		}
		return false;
	}
	
	public static void copyFolder(File src, File dest) throws IOException{
    	if(src.isDirectory()){	 
    		System.out.println("start with making the backup");
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from " + src + "  to " + dest);
    		}
    		String files[] = src.list();
 
    		for (String file : files) {
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   copyFolder(srcFile,destFile);
    		}
    		System.out.println("Files copied from src to dest");
 
    	}else{
    		InputStream in = new FileInputStream(src);
	        OutputStream out = new FileOutputStream(dest); 

	        byte[] buffer = new byte[1024];

	        int length;
	        //copy the file content in bytes 
	        while ((length = in.read(buffer)) > 0){
	    	   out.write(buffer, 0, length);
	        }

	        in.close();
	        out.close();
	        System.out.println("File copied from " + src + " to " + dest);
    	}
    }
}
