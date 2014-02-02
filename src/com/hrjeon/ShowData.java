package com.hrjeon;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by daruken on 2014. 2. 2..
 */
public class ShowData {
    /**
     *
     * @param out
     * @param gameArray
     * @throws IOException
     * @brief Show recent game list
     */
    public void showRecentGame(PrintWriter out, String[] gameArray) throws IOException{
        for(int i=0;i<gameArray.length;i++){
            if(gameArray[i].equals("\"gameMode\""))
                out.println(gameArray[i].replaceAll("\"", "")+":"+gameArray[i+1].replaceAll("\"", "")+"<br>");

            if(gameArray[i].equals("\"subType\""))
                out.println(gameArray[i].replaceAll("\"", "")+":"+gameArray[i+1].replaceAll("\"", "")+"<br>");

            if(gameArray[i].equals("\"championId\"")){
                String str = new String(gameArray[i+1].replaceAll("}", ""));
                out.println(gameArray[i].replaceAll("\"", "")+":"+str.replaceAll("]", "")+"<br>");
            }

            if(gameArray[i].equals("\"spell1\""))
                out.println(gameArray[i].replaceAll("\"", "")+":"+gameArray[i+1].replaceAll("\"", "")+"<br>");

            if(gameArray[i].equals("\"spell2\""))
                out.println(gameArray[i].replaceAll("\"", "")+":"+gameArray[i+1].replaceAll("\"", "")+"<br>");
        }
    }
}
