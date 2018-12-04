const GoogleMaps = require('google-maps');

const MapView = function (container, options) {
  this.container = container;
  this.options = options;
  this.google = null;
  this.googleMap = null;
}

MapView.prototype.render = function () {
  GoogleMaps.load((google) => {
    this.google = google;
    this.googleMap = new this.google.maps.Map(this.container, this.options);
    this.addMarkerOnClick();
  });
}

MapView.prototype.addMarkerOnClick = function() {
  this.googleMap.addListener('click', (event) => {
    this.addMarker(event.latLng);
  });
}

MapView.prototype.addMarker = function(coords) {
  const marker = new this.google.maps.Marker({
    position: coords,
    map: this.googleMap
  });

  this.addInfoWindow(marker);
}

MapView.prototype.addInfoWindow = function(marker) {
  const infoWindow = new this.google.maps.InfoWindow({
    content: `
      Lat: ${marker.position.lat()},
      Lng: ${marker.position.lng()}
    `
  });

  marker.addListener('click', () => {
    infoWindow.open(this.googleMap, marker);
  });
}

module.exports = MapView;
