let MakeupGetter = require('./MakeupGetterES5');

let app = function(){
  let mg = new MakeupGetter("maybelline");
  mg.fetchProducts();
};

window.onload = app;
