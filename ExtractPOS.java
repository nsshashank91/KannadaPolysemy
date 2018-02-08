package com.shash.ssh.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import java.util.List;

import java.util.Map.Entry;


import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

public class ExtractPOS {

	public static void main(String[] args) throws IOException {

		List<String> inputWordsList = null;
		BufferedReader brInput = new BufferedReader(new FileReader("sen31"));
		while (true) {
			String line = brInput.readLine();
			if (line == null)
				break;
			line = line.replaceAll("[-+.^:,]", "");
			String[] splitWords = line.split(" ");
			inputWordsList = Arrays.asList(splitWords);
			// System.out.println(inputWordsList);
		}
		Multimap<String, String> word_pos_map = LinkedListMultimap.create();
		BufferedReader br = new BufferedReader(new FileReader("out3"));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;

			if (line.contains("Sentence") || line.contains("((")
					|| line.contains("))") || line.contains("SYM")) {
				continue;
			} else {
				//System.out.println(line);
				String[] split = line.split("<");
				// System.out.println(split[0]);
				String indexedToken = split[0];
				String[] word_pos = indexedToken.split("\\s");
				/*
				 * System.out.println(word_pos[1]);
				 * System.out.println(word_pos[2]);
				 */
				word_pos_map.put(word_pos[1], word_pos[2]);
			}

		}
		Collection<Entry<String, String>> entries = word_pos_map.entries();
		  entries.forEach(item -> System.out.println(item.getKey()+" :: "+item.getValue()));
	}

}
