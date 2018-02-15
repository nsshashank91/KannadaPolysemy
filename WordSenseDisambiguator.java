package com.shash.ssh.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


public class WordSenseDisambiguator {

	public static void main(String[] args) throws IOException {

		BufferedReader brInput = new BufferedReader(new FileReader(
				"message.txt"));
		String input = "";
		while (true) {
			String line = brInput.readLine();
			if (line == null)
				break;
			input = input + line;
		}
		// System.out.println(input);
		String[] synsets = null;
		if (input.contains("----------------------------")) {
			synsets = input.split("----------------------------");
		}
		List<String[]> semanticsList = new ArrayList<String[]>();
		if (synsets != null) {

			for (String synset : synsets) {
				//System.out.println(synset);
				if (synset.contains("::::::")) {
					String[] synsetFragments = synset.split("::::::");
					String pos = synsetFragments[0];
					String synonyms = synsetFragments[1];
					String gloss = synsetFragments[2];
					String semantics = synonyms + " " + gloss;
					String[] semanticUnitArray = new String[2];
					semanticUnitArray[0] = pos;
					semanticUnitArray[1] = gloss;
					semanticsList.add(semanticUnitArray);
				}
			}
			
			for(String[] semanticUnit:semanticsList){
				System.out.println("POS = "+semanticUnit[0]);
				System.out.println("Semantic = "+semanticUnit[1]);
			}

			
		}

	}

}
