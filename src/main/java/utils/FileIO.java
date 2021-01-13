package utils;

import java.io.*;
import java.util.Map;

public class FileIO implements IO {
    public void readFile(String file, Map<String, Integer> stocks) {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = "";

        try {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            line = bufRdr.readLine();

            while(line != null) {
                String[] lines = line.split(": ");
                stocks.put(lines[0], Integer.parseInt(lines[1]));
                line = bufRdr.readLine();
            }

            fileStrm.close();
        }
        catch (IOException e) {
            if(fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch(IOException ex){}
            }

            stocks.put("NAB", 0);
            stocks.put("CBA", 0);
            stocks.put("QAN", 0);
        }
    }

    public void writeFile(String outString, String fileName) {
        FileOutputStream fileStrm = null;
        PrintWriter output;

        try
        {
            fileStrm = new FileOutputStream(fileName);
            output = new PrintWriter(fileStrm);

            output.close();
            fileStrm.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
}
