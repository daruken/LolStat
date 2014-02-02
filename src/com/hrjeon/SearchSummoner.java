package com.hrjeon;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by daruken on 2014. 1. 30..
 */

@WebServlet("/SearchSummoner")
public class SearchSummoner extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSummoner() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = java.net.URLDecoder.decode(request.getParameter("name"));
        SearchData searchLol = new SearchData();
        ShowData showLol = new ShowData();
        String summonerStr = searchLol.getSummoner(name);

        int i = 0;

        StringTokenizer summonerSt = new StringTokenizer(summonerStr, ":,");
        String summonerArray[] = new String[summonerSt.countTokens()];
        while(summonerSt.hasMoreTokens()){
            summonerArray[i] = summonerSt.nextToken();
            i++;
        }

        StringTokenizer statSt = new StringTokenizer(searchLol.getStat(summonerArray[2]), ":,");
        String statArray[] = new String[statSt.countTokens()];
        i=0;
        while(statSt.hasMoreTokens()){
            statArray[i] = statSt.nextToken();
            i++;
        }

        StringTokenizer gameSt = new StringTokenizer(searchLol.getRecentGame(summonerArray[2]), ":,");
        String gameArray[] = new String[gameSt.countTokens()];
        i=0;
        while(gameSt.hasMoreTokens()){
            gameArray[i] = gameSt.nextToken();
            i++;
        }

        // TODO Auto-generated method stub
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Lol NA Stat</TITLE></HEAD>");
        out.println("<BODY>");

        out.println("Summoner Name: "+summonerArray[4].replaceAll("\"", "")+"<br><br>");
        out.println("Rank Solo 5x5  win:"+statArray[166]+" lose:"+statArray[168]+"<br>");
        out.println("Rank Team 5x5  win:"+statArray[204]+" lose:"+statArray[206]+"<br>");
        out.println("<br>");

        out.println("Recent Game<br>");
        showLol.showRecentGame(out, gameArray);


        out.println("</BODY>");
        out.println("<HTML>");
        out.close();
    }
}

