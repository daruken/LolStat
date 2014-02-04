package com.hrjeon.lol;

/**
 * Created by dennis on 14. 2. 4.
 */
public class LolException extends Exception {
  private Integer responseCode;

  public LolException(Integer responseCode, String message) {
    super(message);

    this.responseCode = responseCode;
  }

  public Integer getResponseCode() {
    return responseCode;
  }
}
