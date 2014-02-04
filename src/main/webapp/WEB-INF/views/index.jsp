<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertTemplate template="/WEB-INF/layout/html.jsp">
  <tiles:insertAttribute name="body">
    <script>
      $(function () {
        var summoner = new Summoner({
              id: "${id}"
            }),
            views = {
              summonerInfoView: new lolstat.view.SummonerInfoView({model: summoner})
            };

        if (summoner.get('id')) {
          summoner.fetch({
            success: function () {
              _.forEach(_.values(views), function (view) {
                view.render();
              });
            }
          });
        }
      });
    </script>
    <div class='nav navbar-fixed-top navbar-inverse' role='navigation'>
      <div class="container">
        <div class='navbar-header'>
          <a class='navbar-brand' href='#'>Quasar</a>
        </div>
        <ul class='nav navbar-nav'>
          <li>
            <form class="navbar-form navbar-left" role="search">
              <div class="form-group">
                <input type="search" class="form-control" placeholder="Summoner Name">
              </div>
              <button type="submit" class="btn btn-success">Search</button>
            </form>
          </li>
        </ul>
      </div>
    </div>

    <div class="container">
      <div id="summoner-info" class="row"></div>
    </div>
  </tiles:insertAttribute>
</tiles:insertTemplate>