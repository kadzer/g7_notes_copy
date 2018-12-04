const Food = function(name, replenValue) {
  this.name = name;
  this.replenValue = replenValue;
  this.isPoisonous = false;
};

module.exports = Food;
