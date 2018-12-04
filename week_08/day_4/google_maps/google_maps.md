# Google Maps

**Lesson Duration: 60 minutes**

### Learning Objectives
- Be able to use the GoogleMaps API documentation
- Be able to render a map using the GoogleMaps API
- Be able to manipulate a Google Map in response to events


## Intro

This lesson is an introduction to using the GoogleMaps API, which enables us to display maps and map elements in the browser. We are also going to look at how to manipulate a map in response to a user's interaction.

The GoogleMaps API is of the library type, in that is gives us a collection of objects and methods that we can use. We will use an npm package to load the GoogleMaps API into our application and handle the asynchronicity of the request.

## Coordinates Finder App

We are going to build a Coordinates Finder app that has a map. Users will be able to click on the map to see the coordinates of their click.

> Instructor note: Hand out start code

```bash
  npm install
  npm run build
```
Open the index.html in the browser and see the title 'Coordinates Finder' displaying.

## Loading the Google Maps API

The GoogleMaps API gives us a library of objects and methods that we can use to create maps and other map elements and functionality. To use it, we need to load the API's library into our application. We are going to use an npm package called [google-maps](https://www.npmjs.com/package/google-maps) that handles the asynchronicity of the request.

```bash
npm install google-maps
```

## Application Architecture

Our app is going to consist of:

- map_view.js, which will be responsible for creating the GoogleMaps `Map`. It will also contain any methods for manipulating the map.
- app.js, which will use `MapView` to render a map after the DOM content has loaded.

## `MapView`

We want a user to be able to click on a map to add a marker. Then when the user clicks on the marker, an info window should open and display the coordinates of the marker.

![Flow of event listeners in `MapView`](./images/googlemaps.png)

*Flow of event listeners in `MapView` that we will use to create GoogleMaps API objects*

### Creating a GoogleMaps `Map` in `MapView`

Let's create `MapView`.

```bash
mkdir views
touch views > map_view.js
```

Looking at the above diagram, we can see the first thing we want the `MapView` to be able to do is to render a map. Let's see how we create a GoogleMaps `Map` by looking at the API's documentation: [https://developers.google.com/maps/documentation/javascript/reference/3.exp/map](https://developers.google.com/maps/documentation/javascript/reference/3.exp/map).

We can see `Map` takes two arguments:

1. Container - The DOM element that the map is going to get rendered inside.
2. Options - This will be an object with properties that determine how map to look.

As the GoogleMaps `Map` is going to need a container and an options object,let's have the `MapView` take those in as arguments. This will mean that `MapView` can be used to create different maps with different containers and options.

```js
// map_view

const MapView = function (container, options) {
  this.container = container;
  this.options = options;
}

```

We want `MapView` to be responsible for creating a new GoogleMaps `Map` using the GoogleMaps API. We will write a `render` method that does this.

As we are going to need to access the API's objects and methods, we are going to make use to the npm package we installed earlier to load the API's library into the application. Let's start by requiring the `google-maps` package into `map_view.js`.

```js
// map_view.js

const GoogleMaps = require('google-maps');
```

The `render` function is going to be responsible for instantiating a new GoogleMaps `Map`. Because requesting the information from the API is asynchronous, we need to use a method, `load`, from the npm package that takes a callback, to render the map once the API library (`google`) is available to us.

```js
MapView.prototype.render = function () {
  GoogleMaps.load((google) => {

  });
}
```

We can then access the `maps` object, which has the `Map` constructor as a property.

```js
MapView.prototype.render = function () {
  GoogleMaps.load((google) => {
    new google.maps.Map(this.container, this.options); // NEW
  });
}
```

## Rendering a Map

Now we can instantiate a `MapView` in app.js. We will need to pass in two arguments:

1. Container - The DOM element that the map is going to get rendered inside.
2. Options - This will be an object that has properties that determine how map to look. It has to have a minimum of two properties:
 - zoom level
 - coordinates to determine the map's centre

So we know we are going to need a DOM element to render the map inside as the first argument. Let's start by creating one.

```html
<!-- index.html -->

<div id="map"></div>
```

We have to give the map container a height and width, otherwise it will default to zero pixels.

```css
/* main.css */

#map {
  border: 1px solid black;
  width: 700px;
  height: 500px;
}
```
We can now get hold of the `div` in app.js, so we have it ready to pass into `MapView`.

```js
// app.js

document.addEventListener('DOMContentLoaded', function () {
  const mapContainer = document.querySelector('#map'); // NEW
});
```

Next we will create an options object to pass into `MapView` as the second argument.

```js
// app.js

document.addEventListener('DOMContentLoaded', function () {
  const mapContainer = document.querySelector('#map');

  const mapOptions = {
    zoom: 2,
    center: {lat: 30, lng: 0}
  }; // NEW
});
```

Lastly we need to require the MapView so that we can use it to to create a map and render it the DOM.

```js

const MapView = require('./views/map_view.js'); // NEW

document.addEventListener('DOMContentLoaded', function () {
  // ...
  const mapView = new MapView(mapContainer, mapOptions); // NEW
  mapView.render(); //NEW
});
```

If we now refresh the browser we see the map displaying.

### Keeping Reference to the API Library and Map

If we look back at `MapView`, we see that inside the `render` method we have two things:

1. The loaded API library (`google`)
2. The instantiated `Map`

Both of these things are only in scope within callback we pass to `GoogleMaps.load`, but we are going to want to use them throughout the `MapView` class. For example, when we want to use the API library to create another map element, or when we want to add a event listener to the map. To solve this problem, let's save them both as properties on the `MapView`.

```js

const MapView = function (container, options) {
  this.container = container;
  this.options = options;
  this.google = null; // NEW
  this.googleMap = null; // NEW
}

MapView.prototype.render = function () {
  GoogleMaps.load((google) => {
    this.google = google; // NEW
    this.googleMap = new this.google.maps.Map(this.container, this.options); // UPDATED
  });
}

```

We now have a `MapView` that can render a map to the DOM and stores the GoogleMaps API library.

### Task: (5 minutes)

The options object that we a pass to the `Map` can have a number of other properties defined. Read the documentation and add some more properties to change the settings of the map. [https://developers.google.com/maps/documentation/javascript/reference/3.exp/map#MapOptions](https://developers.google.com/maps/documentation/javascript/reference/3.exp/map#MapOptions)

<details>
<summary>Example solution</summary>

```js
const mapOptions = {
  zoom: 2,
  center: {lat: 30, lng: 0},
  mapTypeId: 'satellite' // NEW
};
```

</details>
<br>

## Adding Event Listeners to Maps

We want to enable the user to add a marker to the map by clicking on it. To do this we are going a write a method, `addMarkerOnClick` in `MapView`. `addMarkerOnClick` will be responsible for adding a click event listener to the map, and adding the marker.

The GoogleMaps `Map` object has a method on it, `addListener`, which is very similar to the `addEventListener` we have been using to add click events to DOM elements. It takes a callback which takes two arguments:

1. the event it should listen for
2. a callback to execute when the event is fired.

The callback gets passed an event object, which, for now, we will `console.log` so we can have a look at it.

```js
  // ...
  MapView.prototype.addMarkerOnClick = function() {
    this.googleMap.addListener('click', (event) => {
      console.log('event object', event)
    });
  }
```
As the event listener needs to be added as soon as the map is rendered, we need to call `addMarkerOnClick` in `render`.

```js

MapView.prototype.render = function () {
  GoogleMaps.load((google) => {
    // ...
    this.addMarkerOnClick(); // NEW
  });
}

```

Now if you refresh the browser and click on the map, you will see the event object in the console. If you look inside the event object, you will see there is a `latLng` property. Let's update the console.log to display that.

```js
console.log('event latLng', event.latLng);
```

So we now have a map that listens for click events, from which we can retrieve the coordinates of the click.

## Adding Markers to Maps on Click Events

We know we want to create a `Marker` when the click event is fired, so let's look at the GoogleMaps API docs to see what parameters a `Marker` takes:
[https://developers.google.com/maps/documentation/javascript/reference/3.exp/marker](https://developers.google.com/maps/documentation/javascript/reference/3.exp/marker)

We pass a `Marker` an options object with two properties:

1. position (an object with `lat` and `lng` properties)
2. map (the map it should be displayed on)

> Like with `Map`, the options object can contain a number of different properties:
https://developers.google.com/maps/documentation/javascript/reference/3.exp/marker#MarkerOptions

We are going to write an `addMarker` method that is responsible for creating the `Marker`. We are going to use the coordinates object that we got back from the click event listener in `addMarkerOnClick` as the position, so we will create a parameter for it to be passed in. We have reference to the map because we assigned it to `this.googleMap` in `MapView`.

```js
  MapView.prototype.addMarker = function(coords) {
    const marker = new this.google.maps.Marker({
      position: coords,
      map: this.googleMap
    });
  }
```

We want to add a marker when the map is clicked, so we can call `addMarker` in the event listener we created earlier in `addMarkerOnClick`. We will pass in the coordinate we got back from from the click event, which we were previously logging out.

```js
  MapView.prototype.addMarkerOnClick = function() {
    this.googleMap.addListener('click', (event) => {
      this.addMarker(event.latLng); // UPDATED
    });
  }
```
Now when we refresh the browser, we should see markers appear where we click.

## Adding Info Windows to Markers

So we have added a click event to the map, which adds a marker. Let's now add a GoogleMaps `InfoWindow` to each marker so that we display the click's coordinates. We will write a method, `addInfoWindow`, that:

1. takes in a `Marker`
2. creates an `InfoWindow`
3. adds a click event listener to the marker, which opens the info window


```js
  //...
  MapView.prototype.addInfoWindow = function(marker) {

  }
```

Again, let's looks at the docs to see what an InfoWindow object needs when we create it.
https://developers.google.com/maps/documentation/javascript/reference/3.exp/info-window

We need to pass it an object with a content property, containing the string is should display.


```js
  //...
  MapView.prototype.addInfoWindow = function(marker) {
    const infoWindow = new this.google.maps.InfoWindow({
      content: `I am an InfoWindow`
    });
  }
```
We want the info window to open when the marker is clicked, so let's add a listener to the marker, and call the GoogleMaps API method `open` on the info window when the even it fired.

```js
  //...
  MapView.prototype.addInfoWindow = function(marker) {
    const infoWindow = new this.google.maps.InfoWindow({
      content: `I am an InfoWindow`
    });

    marker.addListener('click', () => {
      infoWindow.open(this.googleMap, marker);
    });
  }
```

Finally we need to call `addInfoWindow` when we add the marker to the map, passing in the `Marker` object.

```js

  MapView.prototype.addMarker =
    //...
    this.addInfoWindow(marker);
  }
```

The last step is to get the info window to display the coordinates of the marker. The coordinates are stored in the `position` property on each Marker. The `lat` and `lng` are stored as functions.


```js
  //...
  MapView.prototype.addInfoWindow = function(marker) {
    const infoWindow = new this.google.maps.InfoWindow({
      content: `
        Lat: ${marker.position.lat()},
        Lng: ${marker.position.lng()}
      ` // UPDATED
    });
  }
```

## Recap

<details>
<summary>What did we use the npm package google-maps to achieve?</summary>

To make the request to the GoogleMaps API and handle the asynchronicity of the request, enabling us to create a `Map` once we have the library in scope.

</details>

<details>
<summary>Why did we abstract away how the map is rendered into the `MapView`?</summary>

So that we can create multiple maps, each with different containers and options.

</details>

## Conclusion

The GoogleMaps API gives us a library of objects and methods that we can use to add maps and map functionality to our applications.

Using the GoogleMaps API documentation to look up how to use the API we are now able to use it's methods and objects to update the map in response to a user's interaction.
