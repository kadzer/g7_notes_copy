let MakeupGetterES5 = function (brand) {
  this.brand = brand;
  this.products = [];
}

MakeupGetterES5.prototype = {
  fetchProducts: function () {
    let url = 'http://makeup-api.herokuapp.com/api/v1/products.json?brand=' + this.brand;
    let xhr = new XMLHttpRequest();

    xhr.open('GET', url);
    xhr.addEventListener('load', function () {
      this.products = JSON.parse(xhr.responseText);

      for (let i = 0; i < this.products.length; i++){
        console.log('product at index', i, 'in loop:', this.products[i]);
      }

    }.bind(this));

    xhr.send();
  }
};

module.exports = MakeupGetterES5;
