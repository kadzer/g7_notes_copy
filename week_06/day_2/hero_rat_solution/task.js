const Task = function(difficulty, urgency, reward){
  this.difficulty = difficulty;
  this.urgency = urgency;
  this.reward = reward;
  this.isComplete = false;
}


Task.prototype.markAsComplete = function(){
  this.isComplete = true;
}


module.exports = Task;
