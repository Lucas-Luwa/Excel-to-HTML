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
        try{
            FileWriter writer = new FileWriter(myOutput);
            writer.write("<table>\n");
            Scanner fileScan = new Scanner(myCSV);
            int runNum = 0;
            String currLine = "";
            String[] items = null;

            while(fileScan.hasNextLine()){
                // System.out.println("here");
                currLine = fileScan.nextLine();
                items = currLine.split(",");
                if(runNum==0)writer.write(coreSystems(items, 4, 6));
                else writer.write(coreSystems(items,4,2));
                runNum++;
            }
            // System.out.println(runNum); //Check Run Numbers
            writer.write("</table>\n");
            writer.close();
            fileScan.close();
        }catch(IOException e){
        }
    }
    public static String coreSystems(String[] items, int ctrl1, int ctrl2){
        String[] valueholder = {"<table>", "</table>","<td>","</td>","<tr>","</tr>","<th>","</th>"};
        String newLine = valueholder[ctrl1];
        for(int i = 0; i < items.length; i++){
            newLine = newLine + valueholder[ctrl2] + items[i]+ valueholder[ctrl2+1];
        }
        return newLine+valueholder[ctrl1+1]+"\n";
    }
}