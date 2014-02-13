package com.hrjeon.mvc.summoner;

import com.hrjeon.core.db.Summoner;
import com.hrjeon.core.Lol;
import com.hrjeon.core.LolException;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.Realm;

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

  public Summoner findByName(String name) throws IOException, LolException {
    return (Summoner)ObjectUtils.defaultIfNull(dao.findByName(name), createFromName(name));
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
    return dao.get(id);
  }
}
