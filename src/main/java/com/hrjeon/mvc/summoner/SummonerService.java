package com.hrjeon.mvc.summoner;

import com.hrjeon.db.Summoner;
import com.hrjeon.lol.Lol;
import com.hrjeon.lol.LolException;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by dennis on 14. 2. 4.
 */
@Service
public class SummonerService {
  @Autowired
  private SummonerDao dao;

  @Autowired
  private Lol lol;

  public Summoner searchByName(String name) throws IOException, LolException {
    return (Summoner)ObjectUtils.defaultIfNull(dao.getIdByName(name), createFromName(name));
  }

  public Summoner createFromName(String name) throws IOException, LolException {
    Summoner result = lol.getSummonerByName(name);
    dao.save(result);

    return result;
  }

  public Summoner update(Long id) throws IOException, LolException {
    return null;
  }

  public Summoner get(Long id) {
    return dao.findById(id);
  }
}
