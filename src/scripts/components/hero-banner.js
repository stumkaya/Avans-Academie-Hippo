
var HeroBanner = (function () {

    /*
        This script uses some 'Magic Numbers' which are used to resize the banner images and video.
        These numbers are defined within the constructor and are used to maintain the correct image
        or video aspect ratio. The numbers should match those of the images/video used. Example:

        this.imageBannerRatio = { "width": 3360, "height": 1552 }
    */

    function HeroBanner() {
        this.homeElement = jQuery('.home-hero');
        this.mainElement = jQuery('.component-hero');
        this.bannerElement = jQuery('.component-hero .banner');
        this.eventBanner = jQuery('.component-hero.event');

        this.videoBannerElement = jQuery('.video-banner');
        this.videoCoverElement = jQuery('.video-cover');

        this.navElement = jQuery('.navbar.navbar-default');
        this.scrollDown = jQuery('.scrolldown, .scrollpast');
        this.content = jQuery('.content');

        this.videoBannerRatio = { "width": 1920, "height": 1080 };
        this.imageBannerRatio = { "width": 3360, "height": 1552 };
        this.imageBannerRatioXs = { "width": 764, "height": 496 };

        this.url = '';
        this.urlXs = '';

        if (this.mainElement.length > 0) {
            this.registerResize();
            this.registerEvents();
            this.setupHeroBanner();
        }
    }

    HeroBanner.prototype.setupHeroBanner = function () {
        if (this.mainElement.data('image')) {
            this.url = this.mainElement.data('image');
            this.urlXs = this.url;
            if (this.mainElement.data('image-xs'))
                this.urlXs = this.mainElement.data('image-xs');
        }
        this.setHeroBanner();
    };

    HeroBanner.prototype.setHeroBanner = function () {
        if (this.url.length > 0) {
            if (this.homeElement.length > 0)
                this.homeElement.removeAttr('style');
            this.mainElement.removeAttr('style');
            this.bannerElement.removeAttr('style');
            this.videoBannerElement.removeAttr('style');
            this.videoCoverElement.removeAttr('style');

            this.setHeroImage();
            this.setHeroSize();
        }
    };

    HeroBanner.prototype.setHeroImage = function () {
        if (this.homeElement.length > 0) {
            if (resizeHandler.respondToEquals('xs') || resizeHandler.respondToEquals('sm')) {
                var cookieHeight = jQuery('.cookie-box').height();
                this.homeElement.css({ 'background-image': 'url(\'' + this.urlXs + '\')', 'background-position-y': cookieHeight + 'px'});
            }
        } else {
            if (resizeHandler.respondToEquals('xs')) {
                this.bannerElement.css({ backgroundImage: 'url(\'' + this.urlXs + '\')'});
            } else {
                this.mainElement.css({ backgroundImage: 'url(\'' + this.url + '\')'});
            }
        }
    }

    HeroBanner.prototype.setHeroSize = function () {
        if (this.homeElement.length > 0) {
            if (!resizeHandler.respondToEquals('xs') && !resizeHandler.respondToEquals('sm')) {
                this.homeElement.css({ 'height': jQuery(window).height() + 'px'});
                this.bannerElement.css({ 'height': jQuery(window).height() + 'px'});
                
                var cookieHeight = jQuery('.cookie-box').height();
                this.videoBannerElement.css({ 'height': jQuery(window).height() + 'px'});
                this.videoCoverElement.css({ 'height': jQuery(document).height() + 'px'});
                this.videoCoverElement.children().css({ 'margin-top': (jQuery(window).height() + cookieHeight) + 'px'});
            } else {
                var bannerHeight = (jQuery(window).width() * this.videoBannerRatio.height) / this.videoBannerRatio.width;
                if (jQuery(window).width() > jQuery(window).height())
                    bannerHeight = bannerHeight / 2;

                this.homeElement.css({ "padding-top": Math.floor(bannerHeight) + 'px'});
            }
        } else {
            var bannerHeight = 0;
            if (this.eventBanner.length === 0) {
                if (resizeHandler.respondToEquals('xs'))
                    bannerHeight = (this.mainElement.outerWidth() * this.imageBannerRatioXs.height) / this.imageBannerRatioXs.width;
                else
                    bannerHeight = (this.mainElement.outerWidth() * this.imageBannerRatio.height) / this.imageBannerRatio.width;
                    
                this.bannerElement.css({ height: Math.floor(bannerHeight) + 'px'});
            }
        }
    }

    HeroBanner.prototype.registerResize = function () {
        var that = this;
        resizeHandler.register(function () {
            that.setHeroBanner();
        });
        jQuery(window).load(function() {
            that.setHeroBanner();
        });
    };
    
    HeroBanner.prototype.registerEvents = function () {
        var that = this;
        this.scrollDown.on('click', function(e, i){
            jQuery('html, body').animate({ scrollTop: that.content.offset().top }, 1000);
            return false;
        });
    }
    return HeroBanner;
}());