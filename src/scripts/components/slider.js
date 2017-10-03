
var Slider = (function () {

    function Slider() {
        this.component = jQuery('.component-slider');
        this.slider = jQuery('.slider');
        this.skewContainer = jQuery('.skew-container');
        this.slides = jQuery('.slide');
        this.images = jQuery('.slide-img');
        this.ctrlPrev = jQuery('.ctrl-prev');
        this.ctrlNext = jQuery('.ctrl-next');
        
        this.slideStep = 0;
        this.slideStop = 0;

        if (this.slider.length > 0) {
            this.registerResize();
            this.registerEvents();
            this.setSlider();
        }
    }

    Slider.prototype.setSlider = function () {
        var componentWidth = this.component.width();
        var height = (componentWidth / 4) + 50;
        // if (resizeHandler.respondToEquals('xs')) {
        //     height = (componentWidth) + 50;
        // }
        var skewWidth = (height * 1.1944) -height;
        var totalWidth = (skewWidth * 2) + componentWidth;
        var slideWidth = Math.round(totalWidth / 2);
        // if (resizeHandler.respondToEquals('xs')) {
        //     slideWidth = Math.round((totalWidth / 3) * 2);
        // }
        var sliderWidth = this.slides.length * slideWidth;
        if (this.slides.length > 2) {
            this.slider.css({"left": "0"});
            this.slideStep = Math.round((componentWidth / 2) + (skewWidth / 2));
            this.slideStop = Math.round((this.slideStep * (this.slides.length - 2)) * -1);
            this.ctrlNext.show();
        }

        this.skewContainer.css({"width": sliderWidth + "px"});
        this.slider.css({"width": (sliderWidth - (skewWidth * 2)) + "px"});
        this.slides.css({"height": height + "px", "width": slideWidth + "px", "margin-left": "-" + (skewWidth / 2) + "px"});
        this.images.css({"height": height + "px", "width": slideWidth + skewWidth + "px"});
    }

    Slider.prototype.registerResize = function () {
        var that = this;
        resizeHandler.register(function () {
            that.setSlider();
        });
    }

    Slider.prototype.registerEvents = function () {
        var that = this;
        
        jQuery(this.ctrlNext).on('click', function () {
            var position = that.slider.position();
            var left = position.left - that.slideStep;

            if (that.slideStop <= left) {
                that.slider.css({ "left": left + "px" });

                if (left == that.slideStop) {
                     that.ctrlNext.hide();
                }

                if (left < 0) {
                     that.ctrlPrev.show();
                }
            }
            return false;
        });
        
        jQuery(this.ctrlPrev).on('click', function () {
            var position = that.slider.position();
            var left = position.left + that.slideStep;

            if (left <= 0) {
                that.slider.css({ "left": left + "px" });

                if (left == 0) {
                     that.ctrlPrev.hide();
                }

                if (left <= 0) {
                     that.ctrlNext.show();
                }
            }
            return false;
        });
    }
    
    return Slider;
}());