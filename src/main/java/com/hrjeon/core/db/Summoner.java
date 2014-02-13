package com.hrjeon.core.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by dennis on 14. 2. 4.
 */
@Entity
public class Summoner implements Serializable {
  @Id
  private Long id = null;

  private String name;
  private Integer profileIconId;
  private Long revisionDate;
  private Long summonerLevel;

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProfileIconId(Integer profileIconId) {
    this.profileIconId = profileIconId;
  }

  public void setRevisionDate(Long revisionDate) {
    this.revisionDate = revisionDate;
  }

  public void setSummonerLevel(Long summonerLevel) {
    this.summonerLevel = summonerLevel;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getProfileIconId() {
    return profileIconId;
  }

  public Long getRevisionDate() {
    return revisionDate;
  }

  public Long getSummonerLevel() {
    return summonerLevel;
  }

  @Override
  public String toString() {
    return "Summoner{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", profileIconId=" + profileIconId +
        ", revisionDate=" + revisionDate +
        ", summonerLevel=" + summonerLevel +
        '}';
  }
}
