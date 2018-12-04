const Rat = require('../rat');
const Food = require('../food');
const assert = require('assert');

describe("Rat", function(){

  let rat;
  beforeEach(function(){
    rat = new Rat("Roland");
  });

  it('should have a name', function(){
    assert.strictEqual(rat.name, "Roland");
  });

  it('should make food poisonous if touched', function(){
    let food = new Food("Pizza", 20);
    rat.touchFood(food);
    assert.strictEqual(food.isPoisonous, true);
  })
})
