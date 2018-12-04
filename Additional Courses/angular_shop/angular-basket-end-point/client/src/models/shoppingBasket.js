function shoppingbasket(basketName) {
    this.basketName = basketName;
    this.clearbasket = false;
    this.items = [];

    // load items from local storage when initializing
    this.loadItems();

    // save items to local storage when unloading
    window.addEventListener('unload', function () {
        if(this.clearbasket) {
            this.clearItems();
        }
        this.saveItems();
        this.clearbasket = false;
    });
}

// load items from local storage
shoppingbasket.prototype.loadItems = function () {
    var items = localStorage != null ? localStorage[this.basketName + "_items"] : null;
    if (items != null && JSON != null) {
            var items = JSON.parse(items);
            for (item of items) {
                if (item.code != null && item.name != null && item.price != null && item.quantity != null) {
                    item = new basketItem(item.code, item.name, item.price, item.quantity);
                    this.items.push(item);
                }
            }
    }
}

// save items to local storage
shoppingbasket.prototype.saveItems = function () {
    if (localStorage != null && JSON != null) {
        localStorage[this.basketName + "_items"] = JSON.stringify(this.items);
    }
}

// adds an item to the basket
shoppingbasket.prototype.addItem = function (code, name, price, quantity) {
    quantity = this.toNumber(quantity);
    if (quantity != 0) {

        // update quantity for existing item
        var found = false;
        for (var item of this.items) {
            if (item.code == code) {
                found = true;
                item.quantity = this.toNumber(item.quantity + quantity);
                if (item.quantity <= 0) {
                    this.items.splice(i, 1);
                }
            }
        }

        // new item, add now
        if (!found) {
            var item = new basketItem(code, name, price, quantity);
            this.items.push(item);
        }

        // save changes
        this.saveItems();
    }
}

// get the total price for all items currently in the basket
shoppingbasket.prototype.getTotalPrice = function (code) {
    var total = 0;
    for (var item of this.items) {
        if (code == null || item.code == code) {
            total += this.toNumber(item.quantity * item.price);
        }
    }


    return total;
}

shoppingbasket.prototype.getDiscountedPrice = function (code) {
    var total = 0;
    for (var item of this.items) {
        if (code == null || item.code == code) {
            total += this.toNumber(item.quantity * item.price);
        }
        total -= this.getBogofValue(code);
    }
    total -= this.getTenPercentValue();
    return total;
}

shoppingbasket.prototype.getBogofValue = function (code) {
    var freeProductCount = 0;
    var discount = 0;
    for (var item of this.items) {
        if (code == null || item.code == code) {
            freeProductCount = this.toNumber(Math.floor(item.quantity / 2));
            discount = this.toNumber(item.price * freeProductCount)
        }
    }
    return discount;
};

shoppingbasket.prototype.getTenPercentValue = function () {
    var discountedPrice = this.getTotalPrice() - this.getBogofValue();
    if (discountedPrice >= 20) {
        return discountedPrice * 0.1;
    }
    else {
        return 0;
    }
}

// get the total number of items currently in the basket
shoppingbasket.prototype.getTotalCount = function (code) {
    var count = 0;
    for (var item of this.items) {
        if (code == null || item.code == code) {
            count += this.toNumber(item.quantity);
        }
    }
    return count;
}

// clear the basket
shoppingbasket.prototype.clearItems = function () {
    this.items = [];
    this.saveItems();
}

shoppingbasket.prototype.toNumber = function (value) {
    value = value * 1;
    return isNaN(value) ? 0 : value;
}



// items in the basket
function basketItem(code, name, price, quantity) {
    this.code = code;
    this.name = name;
    this.price = price * 1;
    this.quantity = quantity * 1;
}

module.exports = shoppingbasket
