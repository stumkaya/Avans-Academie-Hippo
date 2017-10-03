
var QuickNav = (function () {

    function QuickNav() {
        this.selector = jQuery('.quick-nav');
        this.container = jQuery('.quick-nav-container');
        this.anchors = jQuery('.anchor');
        this.scrollTime = 1000;
        this.top = 0;
        this.hasFixedDropdown = false;
        this.spacer;

        if (this.container.length > 0) {
            this.updateTop();

            this.registerEvents();
            this.registerScroll();
            this.registerResize();
            this.setupQuickNav();
            this.setupScrollSpy();
        }
    }

    QuickNav.prototype.updateTop = function() {
        var container = $(this.selector).siblings('.container').first();
        this.top = container.offset().top;
    };

    QuickNav.prototype.setupBlackLink = function () {
        // If there is an component-hero we will get the text from there and add it to the navigation.
        var studyName = jQuery('.component-hero:first').find('h1:first').text();

        if (studyName) {

            var blackLink = jQuery('<li><a id="black-link">' + studyName + '</a></li>');

            blackLink.off('click').click(function (e) {
                that.scrollToTop();
            });

            this.container.append(blackLink);
        }
    };

    QuickNav.prototype.setupQuickNav = function () {
        var that = this;
        this.setupBlackLink();

        this.anchors.each(function(j, anchor) {
            var anchorLink = jQuery(anchor).attr('id');
            var anchorName = jQuery(anchor).data('name');

            that.container.append(jQuery('<li><a class="nav-link" href="#' + anchorLink + '">' + anchorName + '</a></li>'));
        });
    };

    QuickNav.prototype.setQuickNav = function () {
        var scrollTop = jQuery(window).scrollTop();

        if (resizeHandler.respondToEquals('xs')) {
            this.selector.removeAttr('style');
            this.selector.removeClass('fixed');

            var spacer = jQuery('#spacer');

            if (scrollTop > this.top) {

                if (spacer.length === 0){
                    // 30 is a nice offset height to make it smooth
                    var height = this.selector.outerHeight() + 30 + 'px';
                    var $spacer = jQuery("<div id='spacer' style='height: "+ height +"'></div>");
                    this.selector.parent().prepend($spacer);
                }

                this.selector.addClass('static');
                this.container.addClass('dropdown-menu');
                this.container.parent().addClass('dropdown');

                var offsetLeft = (jQuery(window).width() - 300) / 2;
                this.container.css({ "left": offsetLeft + "px" });
            } else {
                if (spacer.length === 1) {
                    spacer.remove();
                }
                this.selector.removeClass('static');
                this.container.removeClass('dropdown-menu');
                this.container.parent().removeClass('dropdown');
                this.container.removeAttr('style');
            }
        } else {
            this.selector.removeClass('static');
            this.container.removeClass('dropdown-menu');
            this.container.parent().removeClass('dropdown');
            this.container.removeAttr('style');

            if (scrollTop > this.top) {
                this.selector.addClass('fixed');
            } else {
                this.selector.removeClass('fixed');
            }
        }
    };

    QuickNav.prototype.setupScrollSpy = function () {
        var that = this;
        this.anchors.on('scrollSpy:enter', function() {
            that.spyEvent(this);
        });
        this.anchors.scrollSpy();
    };

    QuickNav.prototype.spyEvent = function(element) {
        var anchor = jQuery(element);

        if (anchor.attr('id') !== undefined) {
            var id = anchor.attr('id');
            this.container.find('li').removeClass('active');

            var toggle = jQuery('.dropdown-toggle', this.selector);
            var item = this.selector.find('[href="#' + id + '"]');
            if (item) {
                item.parent().addClass('active');
                toggle.text(item.text());
            }
        }
    };

    QuickNav.prototype.registerEvents = function () {
        var that = this;
        jQuery('.quick-nav .quick-nav-wrapper').on('click', 'a.nav-link', function(e, i){
            var linkId = $(this).attr("href").toLowerCase();
            $('html, body').animate({ scrollTop: $(linkId).offset().top }, that.scrollTime );
            return false;
        });
    };

    QuickNav.prototype.registerScroll = function () {
        var that = this;
        scrollHandler.register(function () {
            that.setQuickNav();
        });
    };
    
    QuickNav.prototype.registerResize = function () {
        var that = this;
        resizeHandler.register(function () {
            that.updateTop();
        });
    };

    QuickNav.prototype.scrollToTop = function () {
        $('html, body').animate({scrollTop: 0}, this.scrollTime);
    };
    
    return QuickNav;
}());