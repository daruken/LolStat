package com.hrjeon.mvc.realm;

import com.hrjeon.core.db.*;
import com.hrjeon.core.Lol;
import com.hrjeon.core.LolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by dennis on 14. 2. 13.
 */
@Service
public class RealmService {
  @Autowired
  private Lol lol;

  public Realm getRealm() throws IOException, LolException {
    return lol.getRealm();
  }
}
