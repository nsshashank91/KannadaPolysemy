package com.shash.ssh.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PolysemyExtractor {
	
	public static void main(String[] args){
		String input = "ಬಿರುಗಾಳಿಯು ಬಿದಿರಿನ ಸೆಳೆಯನ್ನು ಸೆಳೆಯಿತು";
		input = input.replaceAll("[-+.^:,]", "");
		String[] splitWords = input.split(" ");
		List<String> inputWordsList = Arrays.asList(splitWords);
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addAll(inputWordsList);
		findPolysemyWord(linkedList);
	}

	private static void findPolysemyWord(LinkedList<String> inputWordsList) {
		String polysemyWord = null;
		for(int i=0;i<inputWordsList.size();i++){
			String word = inputWordsList.get(i);
			inputWordsList.remove(i);
			System.out.println(inputWordsList);
			for(String otherToken: inputWordsList){
				int length = word.length();
				int matchLength = 0;
				boolean prestine = true;
				for(int j=0;j<length;j++){
					if(word.charAt(j)==otherToken.charAt(j)){
						continue;
					}
					else{
						matchLength=j;
						prestine = false;
						break;
					}
				}
				if(prestine){
					polysemyWord = word;
					break;
				}
				if(matchLength>1){
					polysemyWord = otherToken.substring(0,matchLength);
					break;
				}
			}
			inputWordsList.add(i,word);
		}
		System.out.println("Polysemy word is "+polysemyWord);
	}
}
