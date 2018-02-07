package com.shash.ssh.test;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


public class ExtractPOS {
	
	public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new FileReader("out3"));
		  while (true)
          {
              String line = br.readLine();
              if (line == null)
                  break;
              System.out.println(line);
          } 
	}

}
