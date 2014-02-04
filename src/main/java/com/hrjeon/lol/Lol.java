package com.hrjeon.lol;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.hrjeon.db.Summoner;
import org.apache.commons.io.IOUtils;
import org.springframework.expression.spel.ast.TypeReference;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class Lol {
  private String apiKey;

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  /**
   *
   * @param name
   * @return Summoner data
   * @throws java.io.IOException
   */
  public Summoner getSummonerByName(String name) throws IOException, LolException {
    StringBuilder sb = new StringBuilder(128);
    sb.append("https://prod.api.pvp.net/api/lol/na/v1.3/summoner/by-name/").
        append(name).
        append("?api_key=").
        append(apiKey);
    URL url = new URL(sb.toString());

    HttpsURLConnection urlConnection = null;
    try {
      urlConnection = (HttpsURLConnection)url.openConnection();
      if (urlConnection.getResponseCode() != 200) {
        throw new LolException(urlConnection.getResponseCode(), IOUtils.toString(urlConnection.getErrorStream(), "UTF-8"));
      }

      ObjectMapper mapper = new ObjectMapper();
      Map<String, Summoner> summoners = mapper.readValue(IOUtils.toString(urlConnection.getInputStream()), MapType.construct(Map.class, SimpleType.construct(String.class), SimpleType.construct(Summoner.class)));
      return summoners.get(name);
    } finally {
      if (urlConnection != null) { urlConnection.disconnect(); }
    }
  }
}
