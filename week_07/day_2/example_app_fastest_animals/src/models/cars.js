const PubSub = require('../helpers/pub_sub.js');

const Cars = function(){
  this.cars = [
    {make: 'Ford', maxSpeed: 135, class: 'Focus'},
    {make: 'Peaugot', maxSpeed: 120, class: '208'},
    {make: 'Bugatti', maxSpeed: 350, class: 'Veron'}
  ];
};

Cars.prototype.bindEvents = function(){
  PubSub.publish('Cars:all-cars-ready', this.cars);
};


module.exports = Cars;
