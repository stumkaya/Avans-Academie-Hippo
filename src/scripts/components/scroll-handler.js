
var ScrollHandler = (function () {
    function ScrollHandler() {
        this.callbacks = [];
        this.running = false;
    }
    ScrollHandler.prototype.scroll = function () {
        if (!scrollHandler.running) {
            scrollHandler.running = true;
            setTimeout(scrollHandler.run, 66);
        }
    };
    ScrollHandler.prototype.run = function () {
        scrollHandler.callbacks.forEach(function (callback) {
            callback();
        });
        scrollHandler.running = false;
    };
    ScrollHandler.prototype.add = function (callback) {
        if (callback)
            this.callbacks.push(callback);
    };
    ScrollHandler.prototype.register = function (callback) {
        if (!this.callbacks.length)
            window.addEventListener('scroll', this.scroll);
        this.add(callback);
    };
    return ScrollHandler;
}());