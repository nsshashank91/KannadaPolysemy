package com.shash.cse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.StreamGobbler;


public class TestShallow {

	public static void main(String[] args){
		try {
			//hello("10.0.2.15","shallow_parser_kan ./shallow-parser-kan-3.0/inpfile out6" , "fedora", "reverse");
			hello("192.168.56.101","./shallow-parser-kan-3.0/bin/sys/kan/shallow_parser_kan.pl C:\\Users\\shashank\\workspaceKannada\\KannadaDisplay\\sen2.txt out9" , "fedora", "reverse");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void hello(String serverIp,String command, String usernameString,String password) throws IOException{
        System.out.println("inside the ssh function");
        try
        {
            Connection conn = new Connection(serverIp);
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(usernameString, password);
            if (isAuthenticated == false)
                throw new IOException("Authentication failed.");        
            ch.ethz.ssh2.Session sess = conn.openSession();
            sess.execCommand(command);  
           ch.ethz.ssh2.Session sess1 = conn.openSession();
            sess1.execCommand("cat out9");
            InputStream stdout = new StreamGobbler(sess1.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout,"UTF8"));
           
            System.out.println("the output of the command is");
            File file = new File("posTagged.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
            while (true)
            {
                String line = br.readLine();
                if (line == null)
                    break;
                System.out.println(line);
                bw.append(line);
            }
            System.out.println("ExitCode: " + sess.getExitStatus());
            bw.flush();
            bw.close();
            sess1.close();
            sess.close();
            conn.close();
        }
        catch (IOException e)
        {
            e.printStackTrace(System.err);

        }
    }
}
