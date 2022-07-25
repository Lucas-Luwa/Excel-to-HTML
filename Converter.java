import java.util.Currency;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Converter{
    public static void main(String[] args){
        File myFile = new File("LHTST.csv");
        mainConverter(myFile);
    }
    public static void mainConverter(File myCSV){
        File myOutput = new File("Output.txt");
        String[] valueholder = {"<table>", "</table>","<td>","</td>","<tr>","</tr>","<th>","</th>"};
        try{
            FileWriter writer = new FileWriter(myOutput);
            Scanner fileScan = new Scanner(myCSV);
            int runNum = 0;
            String currLine = "";
            String[] items = null;

            while(fileScan.hasNextLine()){
                // System.out.println("here");
                currLine = fileScan.nextLine();
                items = currLine.split(",");
                String newLine = valueholder[4];
                for(int i = 0; i < items.length; i++){
                    newLine = newLine + valueholder[6] + items[i]+ valueholder[7];
                }
                writer.write(newLine+"\n");

                runNum++;
            }
            System.out.println(runNum);//Check Run Numbers
            writer.close();
            fileScan.close();
        }catch(IOException e){
        }
    }
}