package com.hrjeon.spring.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dennis on 14. 2. 3.
 */
public class AttributeInterceptor implements WebRequestInterceptor {
  @Override
  public void preHandle(WebRequest request) throws Exception {
    request.setAttribute("lang", request.getLocale().getLanguage(), WebRequest.SCOPE_REQUEST);
  }

  @Override
  public void postHandle(WebRequest request, ModelMap model) throws Exception {
  }

  @Override
  public void afterCompletion(WebRequest request, Exception ex) throws Exception {
  }
}
