package com.hrjeon.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.hrjeon.core.db.Summoner;
import com.hrjeon.core.db.*;
import org.apache.commons.io.IOUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class Lol {
  private String apiKey;
  private String region;

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  /**
   * @param name Summoner name
   * @return Summoner entity
   * @throws IOException
   * @throws LolException
   */
  public Summoner getSummonerByName(final String name) throws IOException, LolException {
    return connect("/api/lol/" + region + "/v1.3/summoner/by-name/" + name, new Function<Summoner>() {
      public Summoner call(InputStream is) throws LolException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Summoner> summoners = mapper.readValue(IOUtils.toString(is), MapType.construct(Map.class, SimpleType.construct(String.class), SimpleType.construct(Summoner.class)));
        return summoners.get(name);
      }
    });
  }

  public Realm getRealm() throws IOException, LolException {
    return connect("/api/lol/static-data/" + region + "/v1/realm", new Function<Realm>() {
      @Override
      public Realm call(InputStream is) throws IOException, LolException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(IOUtils.toString(is), Realm.class);
      }
    });
  }

  private <T> T connect(String path, Function<T> callbackFn) throws IOException, LolException {
    StringBuilder sb = new StringBuilder(128);
    sb.append("https://prod.api.pvp.net").append(path).
        append("?api_key=").
        append(this.apiKey);
    URL url = new URL(sb.toString());

    HttpsURLConnection urlConnection = null;
    try {
      urlConnection = (HttpsURLConnection) url.openConnection();
      if (urlConnection.getResponseCode() != 200) {
        throw new LolException(urlConnection.getResponseCode(), IOUtils.toString(urlConnection.getErrorStream(), "UTF-8"));
      }

      return callbackFn.call(urlConnection.getInputStream());
    } finally {
      if (urlConnection != null) {
        urlConnection.disconnect();
      }
    }
  }

  private interface Function<F> {
    F call(InputStream arg) throws IOException, LolException;
  }
}
