const MapView = require('./views/map_view.js');

document.addEventListener('DOMContentLoaded', function () {
  const mapContainer = document.querySelector('#map-container');

  const mapOptions = {
    zoom: 2,
    center: {lat: 30, lng: 0},
    mapTypeId: 'satellite'
  };

  const mapView = new MapView(mapContainer, mapOptions);
  mapView.render();
});
