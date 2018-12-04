const Hero = function(name, favouriteFood) {
  this.name = name;
  this.favouriteFood = favouriteFood;
  this.health = 100;
  this.tasks = [];
};


Hero.prototype.talk = function(){
  return `My name is ${this.name}`
}

Hero.prototype.addTask = function(task){
  this.tasks.push(task);
}

Hero.prototype.eatFood = function(food){
  if(food.isPoisonous){
    this.health -= food.replenValue;
  }
  else if(food.name === this.favouriteFood){
    this.health += food.replenValue * 1.5;
  } else {
    this.health += food.replenValue;
  }
}

Hero.prototype.sortTasks = function(property){
  this.tasks.sort(function(a, b){
    return a[property] - b[property];
  });
}

Hero.prototype.getCompleteTasks = function(complete){
  let completed = [];
  for (let task of this.tasks){
    if (task.isComplete === complete){
      completed.push(task);
    }
  }
  return completed;
}

module.exports = Hero;
