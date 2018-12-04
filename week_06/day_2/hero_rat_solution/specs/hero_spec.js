var Hero = require('../hero.js');
var Food = require('../food.js');
var Task = require('../task.js');
var Rat = require('../rat.js');
var assert = require('assert');

describe('Hero', function() {

  let hero;

  beforeEach(function(){
    hero = new Hero('Bob','Pizza');

  })
  it('should have a name', function() {
    assert.strictEqual(hero.name, 'Bob');
  });
  it('should start at 100 health', function() {
    assert.strictEqual(hero.health, 100);
  });
  it('should have a fav food', function() {
    assert.strictEqual(hero.favouriteFood, 'Pizza');
  });
  it('should be able to say its name', function(){
    assert.strictEqual(hero.talk(), "My name is Bob");
  });

  describe('Tasks', function(){
    it('should have a collection of tasks', function(){
      assert.deepStrictEqual(hero.tasks, []);
    });

    it('should be able to add task', function(){
      let task = new Task(50, 1, 100);
      hero.addTask(task);
      assert.deepStrictEqual(hero.tasks, [task])
    });



    it('should be able to sort task by difficulty', function(){
      let task1 = new Task(4, 10 , 100);
      let task2 = new Task(2, 10 , 100);
      let task3 = new Task(1, 10 , 100);
      hero.addTask(task1);
      hero.addTask(task2);
      hero.addTask(task3);
      hero.sortTasks("difficulty");
      assert.deepStrictEqual(hero.tasks, [task3, task2, task1]);
    });

    it('should be able to sort by urgency', function(){
      let task1 = new Task(4, 30 , 100);
      let task2 = new Task(2, 10 , 100);
      let task3 = new Task(1, 20 , 100);
      hero.addTask(task1);
      hero.addTask(task2);
      hero.addTask(task3);
      hero.sortTasks("urgency");
      assert.deepStrictEqual(hero.tasks, [task2, task3, task1]);
    });

    it('should be able to view complete tasks', function(){
      let task1 = new Task(4, 30 , 100);
      let task2 = new Task(2, 10 , 100);
      let task3 = new Task(1, 20 , 100);
      hero.addTask(task1);
      hero.addTask(task2);
      hero.addTask(task3);
      task2.markAsComplete();
      const actual = hero.getCompleteTasks(true);
      assert.deepStrictEqual(actual, [task2]);

    });
  });


  describe("Food", function(){
    it('should be able to eat food', function(){
      let food = new Food('Banana', 10);
      hero.eatFood(food);
      assert.strictEqual(hero.health, 110);
    });

    it('health should go up by 1.5 if fav food', function(){
      let food = new Food("Pizza", 50);
      hero.eatFood(food);
      assert.strictEqual(hero.health, 175);
    });

    it("health should go down if food is poisoned", function(){
      let food = new Food("Cheese", 10);
      let rat = new Rat("Roland");
      rat.touchFood(food);
      hero.eatFood(food);
      assert.strictEqual(hero.health, 90);
    });
  });
});
