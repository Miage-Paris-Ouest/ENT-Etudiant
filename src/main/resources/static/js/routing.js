var myApp = angular.module('myApp', ['ngRoute']);

myApp.config(function ($routeProvider) {
    $routeProvider
        .when('/',
            {
                templateUrl: 'ent/accueil.html'
            })
        .when('/maClasse',
            {
                templateUrl: 'ent/MaClasse.html',
                controller: 'maClasseController'
            });
});

myApp.controller('maClasseController', ['$scope', '$log', function ($scope, $log) {
    console.log("maClasseController");

    $('ul.tabs').tabs('select_tab', 'allNews');

    $(".listContainer").mCustomScrollbar({
        theme: "dark"
    });
}]);