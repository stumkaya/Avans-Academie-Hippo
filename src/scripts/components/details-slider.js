
var DetailsSlider = (function () {

    function DetailsSlider() {
        this.component = jQuery('.component-details');
        this.pageLeft = jQuery('.component-details .page-left');
        this.pageRight = jQuery('.component-details .page-right');
        this.slides = jQuery('.component-details .niveau-container');
        this.pagerState = jQuery('.component-details .pager-state');

        this.slide = 0;

        if (this.component.length > 0) {
            this.registerEvents();
            this.setupSlides();
        }
    }
    
    DetailsSlider.prototype.setupSlides = function() {
        if (this.slides.length > 0) {
            var that = this;
            this.slides.each(function() {
                that.slide = that.slide + 1;
                if (jQuery(this).hasClass('ad')) {
                    return false;
                }
            });
        }
    }

    DetailsSlider.prototype.setSlider = function() {
        var that = this;
        this.pagerState.each(function() {
            jQuery(this).children('li').removeClass('active').addClass('inactive');
            var item = $(this).children('li')[that.slide - 1];
            jQuery(item).addClass('active');
        });

        jQuery(this.slides).parent().addClass('hidden-xs hidden-sm');
        jQuery(this.slides[this.slide - 1]).parent().removeClass('hidden-xs hidden-sm');

        if (this.slide === 1) {
            jQuery(this.pageLeft).parent().hide();
        } else {
            jQuery(this.pageLeft).parent().show();
        }

        if (this.slide === this.slides.length) {
            jQuery(this.pageRight).parent().hide();
        } else {
            jQuery(this.pageRight).parent().show();
        }
    }


    DetailsSlider.prototype.registerEvents = function () {
        var that = this;
        
        jQuery(this.pageLeft).on('click', function() {
            if (that.slide > 1) {
                that.slide = that.slide - 1;
                that.setSlider();
            }
            return false
        });

        jQuery(this.pageRight).on('click', function() {
            if (that.slide < that.slides.length) {
                that.slide = that.slide + 1;
                that.setSlider();
            }
            return false;
        });
    }
    
    return DetailsSlider;
}());