
var ResizeHandler = (function () {
    function ResizeHandler() {
        this.callbacks = [];
        this.running = false;
        this.respondTo = window.getComputedStyle(document.body, ':after').getPropertyValue('content');
    }
    ResizeHandler.prototype.resize = function () {
        if (!resizeHandler.running) {
            resizeHandler.running = true;
            resizeHandler.respondTo = window.getComputedStyle(document.body, ':after').getPropertyValue('content');
            setTimeout(resizeHandler.run, 66);
        }
    };
    ResizeHandler.prototype.run = function () {
        resizeHandler.callbacks.forEach(function (callback) {
            callback();
        });
        resizeHandler.running = false;
    };
    ResizeHandler.prototype.add = function (callback) {
        if (callback)
            this.callbacks.push(callback);
    };
    ResizeHandler.prototype.register = function (callback) {
        if (!this.callbacks.length)
            window.addEventListener('resize', this.resize);
        this.add(callback);
    };
    ResizeHandler.prototype.respondToEquals = function (input) {
        if (this.respondTo.indexOf(input) === -1)
            return false;
        return true;
    };
    return ResizeHandler;
}());