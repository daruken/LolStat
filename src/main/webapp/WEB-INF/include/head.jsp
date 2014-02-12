<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 14. 2. 12
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class='nav navbar-fixed-top navbar-default' role='navigation'>
  <div class="container">
    <div class='navbar-header'>
      <a class='navbar-brand' href='#'>Quasar</a>
    </div>
    <ul class='nav navbar-nav'>
      <li>
        <form class="navbar-form navbar-left" role="form" action="/">
          <div class="form-group">
            <input name="name" type="search" class="form-control" placeholder="Summoner Name">
          </div>
          <button type="submit" class="btn btn-success">Search</button>
        </form>
      </li>
    </ul>
  </div>
</nav>