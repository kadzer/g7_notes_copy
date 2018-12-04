const PubSub = require('../helpers/pub_sub.js');

const SelectView = function(element){
  this.element = element;
};

SelectView.prototype.bindAnimalEvents = function(){
  PubSub.subscribe('Animals:all-animals-ready', (evt) => {
    const allAnimals = evt.detail;
    this.populateAnimals(allAnimals);
  });
  this.element.addEventListener('change', (evt) => {
    const selectedIndex = evt.target.value;
    PubSub.publish('SelectView:change', selectedIndex);
  });
};

  SelectView.prototype.bindCarEvents = function(){
    PubSub.subscribe('Cars:all-cars-ready', (evt) => {
      const allCars = evt.detail;
      this.populateCars(allCars);
    });
  };



SelectView.prototype.populateAnimals = function(animalsData){
  animalsData.forEach((animal, index) => {
    const option = document.createElement('option');
    option.textContent = animal.species;
    option.value = index;
    this.element.appendChild(option);
  })
};

SelectView.prototype.populateCars = function(carsData){
  carsData.forEach((car, index) => {
    const option = document.createElement('option');
    option.textContent = car.make;
    option.value = index;
    this.element.appendChild(option);
  })
};

module.exports = SelectView;
