
var MainMenu = (function () {

    function MainMenu() {
        this.show = jQuery('.menu-show');
        this.hide = jQuery('.menu-hide');
        this.nav = jQuery('nav.navbar-default');
        this.menu = jQuery('.main-menu');
        this.menuLeft = jQuery('.main-menu-left');
        this.menuRight = jQuery('.main-menu-right');
        this.menuItems = jQuery('.menu-item');
        this.menuItem = jQuery('.menu-item > a');
        this.menuItemToggle = jQuery('.menu-item-toggle');
        this.quickNav = jQuery('.quick-nav');

        this.panelWidth = 0;
        this.skewWidth = 0;

        if (this.menu.length > 0) {
            this.registerEvents();
            this.registerResize();
            this.setupMenu();
        }
    }

    MainMenu.prototype.setupMenu = function() {
        this.skewWidth = (jQuery(window).height() * 1.1944) - jQuery(window).height();
        this.panelWidth = (jQuery(window).width() / 2) + (this.skewWidth / 2);

        if (!resizeHandler.respondToEquals('xs')) {
            this.menuLeft.find('> div').css({'right': (this.skewWidth / 2) + 'px'});

            if (this.nav.hasClass('menu-open')) {
                this.menu.css({ 'height': jQuery(window).height() + 'px'});
                this.menuLeft.css( { 'left': '-' + (this.skewWidth / 2) + 'px', 'height': jQuery(window).height() + 'px', 'width': this.panelWidth + 'px' } );
                this.menuRight.css( { 'right': '-' + (this.skewWidth / 2) + 'px', 'height': jQuery(window).height() + 'px', 'width': this.panelWidth + 'px' } );
            } else {
                this.menuLeft.css( { 'left': '-' + this.panelWidth + 'px', 'height': jQuery(window).height() + 'px', 'width': this.panelWidth + 'px' } );
                this.menuRight.css( { 'right': '-' + this.panelWidth + 'px', 'height': jQuery(window).height() + 'px', 'width': this.panelWidth + 'px' } );
            }
        } else {
            this.menuItems.removeClass('active');
            this.menuItems.children().removeAttr('style');

            this.menu.removeAttr('style');
            this.menuLeft.removeAttr('style');
            this.menuRight.removeAttr('style');
        }
    }

    MainMenu.prototype.openMenu = function () {
        this.nav.addClass('menu-open');
        this.quickNav.addClass('hide');
        
        if (!resizeHandler.respondToEquals('xs')) {
            this.menu.css({ 'height': jQuery(window).height() + 'px'});
            this.menuLeft.animate({ 'left': '-' + (this.skewWidth / 2) + 'px' }, 500);
            this.menuRight.animate({ 'right': '-' + (this.skewWidth / 2) + 'px' }, 500);
        }
    }

    MainMenu.prototype.closeMenu = function() {
        this.menuItems.removeClass('active');
        this.quickNav.removeClass('hide');

        if (!resizeHandler.respondToEquals('xs')) {
            this.menuLeft.animate({ 'left': '-' + (this.panelWidth + (this.skewWidth / 2)) + 'px' }, 500);
            this.menuRight.animate({ 'right': '-' + (this.panelWidth + (this.skewWidth / 2)) + 'px' }, 500);
            setTimeout(function(){ 
                mainMenu.nav.removeClass('menu-open');
                mainMenu.menu.css({ 'height': '0px'});
            }, 500);
        } else {
            mainMenu.nav.removeClass('menu-open');
        }
    }

    MainMenu.prototype.registerEvents = function () {
        var that = this;

        this.show.on('click', function () {
            that.openMenu();
            return false;
        });

        this.hide.on('click', function () {
            that.closeMenu();
            return false;
        });

        this.menuItemToggle.on('click', function () {
            if (!resizeHandler.respondToEquals('xs'))
                that.menuItems.removeClass('active');
            jQuery(this).parent().toggleClass('active');
            return false;
        });

        this.menuItem.on('mouseover', function () {
            if (!resizeHandler.respondToEquals('xs')) {
                var _active = jQuery(this).parent().hasClass('active')
                that.menuItems.removeClass('active');
                jQuery(this).parent().toggleClass('active');

                                
                jQuery(this).parent().children('div').each(function(s, subitem){
                    var itemWidth = jQuery(this).parent().width() - 30;
                    var maxWidth = that.nav.width() / 4;
                    jQuery(subitem).css({'left': (itemWidth + that.skewWidth + 50) + 'px', 'width': maxWidth + 'px'});
                });


                if (!_active) {
                    return false;
                }
            }
        });
    }

    MainMenu.prototype.registerResize = function () {
        var that = this;
        resizeHandler.register(function () {
            that.setupMenu();
        });
    };
    
    return MainMenu;
}());