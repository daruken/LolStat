<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertTemplate template="/WEB-INF/layout/html.jsp">
  <tiles:putAttribute name="body">
    <article class="container">
      <p>
        icon: <img src="${realm.cdn}/${realm.v}/img/profileicon/${summoner.profileIconId}.png" /> <br>
        id: <small>${summoner.id}</small> <br>
        name: <small>${summoner.name}</small>
      </p>
    </article>
  </tiles:putAttribute>
</tiles:insertTemplate>