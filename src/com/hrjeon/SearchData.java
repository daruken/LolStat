package com.hrjeon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by daruken on 2014. 2. 1..
 */
public class SearchData {
    /**
     *
     * @param name
     * @return Summoner data
     * @throws IOException
     */
    public String getSummoner(String name) throws IOException{
        String summonerUrl = "https://prod.api.pvp.net/api/lol/na/v1.3/summoner/by-name/"+name+"?api_key=b360652d-5ee4-4a7a-bacf-f9aa88e92943";
        URL url = new URL(summonerUrl);

        BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
        return input.readLine();
    }

    /**
     *
     * @param id
     * @return Stat data
     * @throws IOException
     */
    public String getStat(String id) throws IOException{
        String statUrl = "https://prod.api.pvp.net/api/lol/na/v1.2/stats/by-summoner/"+id+"/summary?api_key=b360652d-5ee4-4a7a-bacf-f9aa88e92943";
        URL url = new URL(statUrl);

        BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
        return input.readLine();
    }

    /**
     *
     * @param id
     * @return Recent game record data
     * @throws IOException
     */
    public String getRecentGame(String id) throws IOException{
        String gameUrl = "https://prod.api.pvp.net/api/lol/na/v1.3/game/by-summoner/"+id+"/recent?api_key=b360652d-5ee4-4a7a-bacf-f9aa88e92943";
        URL url = new URL(gameUrl);

        BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
        return input.readLine();
    }
}
