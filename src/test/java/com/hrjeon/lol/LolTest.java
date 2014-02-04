package com.hrjeon.lol;

import com.hrjeon.db.Summoner;
import com.hrjeon.test.support.AbstractSpringTestContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dennis on 14. 2. 4.
 */
public class LolTest extends AbstractSpringTestContext {
  @Autowired
  private Lol lol;

  @Test
  public void testGetSummonerByName() throws Exception {
    Summoner summoner = lol.getSummonerByName("daruken");

    assertNotNull(summoner);
    assertEquals("daruken".toLowerCase(), summoner.getName().toLowerCase());
  }
}
