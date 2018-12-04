const seedData = [
  {name: 'Toni', species: 'Siberian Tiger', continent: 'Asia'},
  {name: 'Rachel', species: 'Northern White Rhino', continent: 'Africa'},
  {name: 'Otis', species: 'Giant Otter', continent: 'South America'},
];

const formSubmitHandler = function(evt) {
  evt.preventDefault();
  const form = evt.target;
  renderListItemFromForm(form);
  form.reset();
};

const renderListItemFromForm = function(form) {
  const animal = formValues(form);
  const listItem = createListItem(animal);
  addListItem(listItem);
}

const formValues = (form) => ({
  name: form.name.value,
  species: form.species.value,
  continent: form.continent.value
});

const createListItem = function(animal) {
  const li = document.createElement('li');
  li.textContent = animal.name;

  const speciesSpan = document.createElement('span');
  speciesSpan.classList.add('species');
  speciesSpan.textContent = animal.species;
  li.appendChild(speciesSpan);

  const continentSpan = document.createElement('span');
  continentSpan.textContent = animal.continent;
  continentSpan.classList.add('continent');
  li.appendChild(continentSpan);

  return li;
};

const addListItem = function(listItem) {
  const listContainer = document.querySelector('#list');
  listContainer.appendChild(listItem);
};

document.addEventListener('DOMContentLoaded', () => {
  const form = document.querySelector('form');
  form.addEventListener('submit', formSubmitHandler);

  seedData.forEach((animal) => {
    const li = createListItem(animal);
    addListItem(li);
  });
});
