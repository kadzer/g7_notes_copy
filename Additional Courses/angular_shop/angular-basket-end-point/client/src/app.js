'use strict';

const angular = require('angular');
const angularRoute = require('angular-route')
const shopController =  require('./models/controller')
const product =  require('./models/product')
const shop =  require('./models/shop')
const shoppingBasket =  require('./models/shoppingBasket')


var shopApp = angular.module('AngularShop', [angularRoute]).
  config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
  $routeProvider.
      when('/shop', {
        templateUrl: 'partials/shop.html',
        controller: shopController
      }).

      when('/basket', {
        templateUrl: 'partials/shoppingbasket.html',
        controller: shopController
      }).
      otherwise({
          redirectTo: '/shop'
      });
}]);

shopApp.factory("DataService", function () {

    // create shop
    var myShop = new shop();

    // create shopping basket
    var mybasket = new shoppingBasket("AngularShop");

    // return data object with shop and basket
    return {
        shop: myShop,
        basket: mybasket
    };
});
