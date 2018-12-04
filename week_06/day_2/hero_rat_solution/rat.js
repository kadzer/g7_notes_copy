const Rat = function(name){
  this.name = name;
}

Rat.prototype.touchFood = function(food){
  food.isPoisonous = true;
}

module.exports = Rat;
