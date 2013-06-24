package fileHandling;

import java.io.File;
import java.io.IOException;

public class LConfigFile {
	private LFile file;
	private String programName;
	
	private int varAmount = 0;
	private String varName[] = new String[100];
	private String varStart[] = new String[100];
	private String varTxt[] = new String[100];
	
	public LConfigFile(File path, String programName){
		file = new LFile(path);
		this.programName = programName;
	}
	
	public boolean exists(){
		return file.exist();
	}
	
	public void addVar(String name, String startValue, String explination){
		varName[varAmount] = name;
		varStart[varAmount] = startValue;
		varTxt[varAmount] = explination;
		varAmount++;
	}
	
	public void create() throws IOException{
		file.create();
		
			file.append("##########################################################");
			file.append("##							##");
			file.append("##							##");
			file.append("##			"+programName+"			##");
			file.append("##							##");
			file.append("##							##");
			file.append("##	everything with ## will be ignored		##");
			file.append("##########################################################");
			file.append("");
			
			for(int i = 0;  !(varAmount == i);i++){
				if(!(varTxt[i].length() == 0)){
					file.append("##" + varTxt[i]);
				}
				file.append(varStart[i]);
				file.append("");
			}
	}
	
	public String open(String name) throws IOException{
		int i = 0;
		file.open(true);
		
		while(i < 1000){
			if(varName[i].equals(name)){
				break;
			}
			i++;
		}
		return file.list.get(i+1);
	}
	
}
