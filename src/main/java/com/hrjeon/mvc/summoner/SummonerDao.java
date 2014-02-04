package com.hrjeon.mvc.summoner;

import com.hrjeon.db.Summoner;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by dennis on 14. 2. 4.
 */
@Repository
public class SummonerDao {
  @Autowired
  private SessionFactory sessionFactory;

  public Summoner findById(Long id) {
    return (Summoner)sessionFactory.getCurrentSession().get(Summoner.class, id);
  }

  public void save(Summoner summoner) {
    sessionFactory.getCurrentSession().saveOrUpdate(summoner);
  }


  public Object getIdByName(String name) {
    return (Summoner)sessionFactory.getCurrentSession()
        .createCriteria(Summoner.class)
        .add(Restrictions.eq("name", name))
        .setProjection(Projections.id())
        .uniqueResult();
  }
}
