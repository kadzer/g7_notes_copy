const PubSub = require('../helpers/pub_sub.js');

const WordCounter = function(){

};

WordCounter.prototype.bindEvents = function(){
  PubSub.subscribe('InputView:text-inputted', (event) => {
    const inputtedText = event.detail;
    const result = this.countWords(inputtedText);
    PubSub.publish('WordCounter:result', result);
  });
};

WordCounter.prototype.countWords = function(text){
  const words = text.trim().split(' ');
  return words.length;
};

module.exports = WordCounter;
