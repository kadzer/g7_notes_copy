const Animals = require('./models/animals.js');
const Cars = require('./models/cars.js');
const SelectView = require('./views/select_view.js');
const AnimalInfoView = require('./views/animal_info_view.js');

document.addEventListener('DOMContentLoaded', function(){
  const selectElement = document.querySelector('select#animals-dropdown');
  const animalDropdown = new SelectView(selectElement);
  animalDropdown.bindAnimalEvents();

  const infoDiv = document.querySelector('div#animal-info')
  const animalInfoDisplay = new AnimalInfoView(infoDiv);
  animalInfoDisplay.bindEvents();

  const animalsDataSource = new Animals();
  animalsDataSource.bindEvents();

  const carSelectElement = document.querySelector('select#cars-dropdown');
  const carDropdown = new SelectView(carSelectElement);
  carDropdown.bindCarEvents();


  const carsDataSource = new Cars();
  carsDataSource.bindEvents();


});
