package fileHandling;

import java.security.SecureRandom;

public class LCode {

	private int code;
	
	public LCode(){
		SecureRandom r;
		int code;
		while(true){	
			r = new SecureRandom();
			code = r.nextInt();
			if(String.valueOf(code).startsWith("-")){
				code = code*-1;
			}
			if(String.valueOf(code).length() == 10){
				int tempI = 0;
				code = Integer.parseInt(String.valueOf(code).substring(0, 8));
				for(int i = 0; i < 8 ; i++){				
					tempI = tempI + Integer.parseInt(String.valueOf(code).substring(i, i+1));
				}
				code = Integer.parseInt(String.valueOf(code) + String.valueOf(tempI));
			}
		}
	}

	public boolean checkCode(int c){
		if(!(String.valueOf(c).length() == 10)){
			return false;
		}
		int tempI = 0;
		for(int i = 0; i < 8 ; i++){				
			tempI = tempI + Integer.parseInt(String.valueOf(c).substring(i, i+1));
		}
		if(tempI == Integer.parseInt(String.valueOf(c).substring(8,10))){
			return true;
		}
		return false;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	
}
