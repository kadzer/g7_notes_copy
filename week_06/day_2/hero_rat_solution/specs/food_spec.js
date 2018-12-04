var assert = require('assert');
var Food = require('../food');

describe('Food', function() {

  let food;

  beforeEach(function(){
    food = new Food('Banana', 20);
  });

  it('should have a name', function() {
    assert.equal(food.name, 'Banana');
  });
  it('should have a replenishment value', function() {
    assert.equal(food.replenValue, 20);
  });

});
