
var CookieBox = (function () {

    function CookieBox() {
        this.cookieDuration = 30; // Number of days before the cookie expires, and the banner reappears
        this.cookieName = 'avanscookie'; // Name of our cookie
        this.cookieValue = 'on';

        this.cookieToggle = jQuery('.cookie-toggle');
        this.cookieBox = jQuery('.cookie-box');

        if (this.cookieBox.length > 0) {
            this.registerEvents();
            this.showCookieDisclaimer();
        }
    }

    CookieBox.prototype.registerEvents = function () {
        var that = this;
        jQuery(this.cookieToggle).on('click', function () {
            that.createCookie(that.cookieName, that.cookieValue, that.cookieDuration);
            that.removeCookieBox();
            return false;
        });
    }

    CookieBox.prototype.showCookieDisclaimer = function() {
        if (this.checkCookie(this.cookieName) != this.cookieValue)
            this.cookieBox.addClass("show");
    }

    CookieBox.prototype.removeCookieBox = function() {
        jQuery(this.cookieBox).removeClass('show');
        resizeHandler.resize();
    }

    CookieBox.prototype.createCookie = function(name, value, days) {
        if (days) {
            var date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            var expires = "; expires=" + date.toGMTString();
            this.removeCookieBox();
        }
        else {
            var expires = "";
        }
        document.cookie = name+"="+value+expires+"; path=/";
    }

    CookieBox.prototype.checkCookie = function(name) {
        var nameEQ = name + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1, c.length);
            }
            if (c.indexOf(nameEQ) == 0) {
                return c.substring(nameEQ.length, c.length);
            }
        }
        return null;
    }

    return CookieBox;
}());
