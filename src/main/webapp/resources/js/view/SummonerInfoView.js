lolstat.view.SummonerInfoView = Backbone.View.extend({
  el: "#summoner-info",
  template: _.template('\
  <div class="col-md-5"><img src="/resources/img/summoner-icon/<@= profileIconId @>.jpg" /></div>\
  <div class="col-md-7">\
    <p>\
      <h2><@= name @></h2>\
      level: <@= level @>\
    </p>\
  </div>\
  \
  '),

  render: function () {
    this.template(this.model);
  }
});