/*
 *   Class name: FileIO
 *   PURPOSE: Perform read and write to/from file
 */

package utils;

import java.io.*;
import java.math.BigDecimal;
import java.util.Map;

public class FileIO implements IO {

    /* Read from file and restore state of stock volume and income if file exists
    *  Populate the given stocks map with 0 for each stock if file does not exist
    *  Return income of the exchange
    */
    public BigDecimal readFile(String file, Map<String, Integer> stocks) {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = "";
        BigDecimal income = new BigDecimal("0");

        try {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            /* first line contains the income */
            line = bufRdr.readLine();
            income = new BigDecimal(line);
            line = bufRdr.readLine();

            /* subsequent lines contain the stock volume */
            while(line != null && !line.isEmpty()) {
                String[] lines = line.split(":");
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
        return income;
    }

    /* Write to file */
    public void writeFile(String outString, String fileName, boolean append) {
        FileOutputStream fileStrm = null;
        PrintWriter output;

        try
        {
            fileStrm = new FileOutputStream(fileName, append);
            output = new PrintWriter(fileStrm);

            output.println(outString);
            output.close();
            fileStrm.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
}
