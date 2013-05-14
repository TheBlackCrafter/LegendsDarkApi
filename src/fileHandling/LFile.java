package fileHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class LFile {

	private File f;
	private Scanner s;
	public String[] string = new String[1000];
	private int p;
	
	public boolean create(){
		try {
			f.createNewFile();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String[] open(boolean ignoreEmpty){
		if(ignoreEmpty){
			try{    
				for(int i = 1; s.hasNext(); ){
					string[i] = s.next();
					
					if(string[i].substring(0, 2) != null && !string[i].substring(0, 2).equals("##")){
						i++;
					}
					else{
						s.nextLine();
					}
				}
			}
			catch(Exception e){  System.out.println("could not find the file");   }
			return string;
		}
		else if(!ignoreEmpty){
			try{   
				for(int i = 1; s.hasNext(); i++){
					string[i] = s.next();
				}
			}
			catch(Exception e){  System.out.println("could not find the file");   }
			return string;
		}
		return string;
	}
	
	public void append(String txt){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(f, true));
			out.append(txt + System.getProperty("line.separator"));
			out.close();
		
		} catch (IOException ex) {System.out.println("IO EXCEPTION: "+ex);}
	}
	
	public File getFile() {
		return f;
	}

	public void setFile(File f) {
		this.f = f;
		try {
			s = new Scanner(this.f);
		} catch (FileNotFoundException e) {
		}
	}
	
	public boolean Copy(File to){
		try {
			Files.copy( f.toPath(), to.toPath() );
			return true;
		} catch (IOException e) {
			System.out.println(e);
			return false;

		}
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
}
