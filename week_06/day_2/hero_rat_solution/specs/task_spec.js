var assert = require('assert');
const Task = require('../task.js');

describe("Task", function(){

  let task;

  beforeEach(function(){
    task = new Task(50, 1, 100);
  });

  it('should have difficulty', function(){
    assert.strictEqual(task.difficulty, 50);
  });

  it('should have urgency', function(){
    assert.strictEqual(task.urgency, 1);
  });

  it('should have a reward', function(){
    assert.strictEqual(task.reward, 100);
  });

  it('should not be complete at first', function(){
    assert.strictEqual(task.isComplete, false);
  });

  it('should be able to be marked as complete', function(){
    task.markAsComplete();
    assert.strictEqual(task.isComplete, true);
  })
});
