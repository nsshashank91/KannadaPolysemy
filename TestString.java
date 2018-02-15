package com.shash.ssh.test;

public class TestString {
	
	 
	
	public static void main(String[] args){
		String str1 = "ಕಲಿಯು";
		String str2 = "ಕಲಿತನು";
	
		int length = str1.length();
		int matchLength=0;
		for(int i=0;i<length;i++){
			if(str1.charAt(i)==str2.charAt(i)){
				continue;
			}
			else{
				matchLength=i;
				break;
			}
		}
		System.out.println("Match length = "+matchLength);
		System.out.println("Matching word = "+str1.substring(0,matchLength));
		
	}

}
