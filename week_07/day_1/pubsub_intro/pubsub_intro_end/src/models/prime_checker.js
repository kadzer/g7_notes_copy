const PubSub = require('../helpers/pub_sub.js');

const PrimeChecker = function() {

};

PrimeChecker.prototype.bindEvents = function () {
  PubSub.subscribe('InputView:number-inputted', (event) => {
    const inputtedNumber = event.detail;
    const result = this.numberIsPrime(inputtedNumber);
    PubSub.publish('PrimeChecker:result', result);
  });
};

PrimeChecker.prototype.numberIsPrime = function (number) {
  for (let i = 2; i < number; i++) {
    if (number % i === 0) {
        return false;
    }
  }
  return number > 1;
};

module.exports = PrimeChecker;
