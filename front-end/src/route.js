var app = angular.module("myApp", ["ngRoute"]);

app.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
    .when("/home", {
      templateUrl: "pages/home.html",
      controller: HomeController,
    })
    .when("/home/:id", {
      templateUrl: "pages/detail.html",
      controller: DetailController,
    })
    .otherwise({
      redirectTo: "/home",
    });
});
