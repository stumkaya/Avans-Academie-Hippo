
var TabHandler = (function () {

    function TabHandler() {
        this.tabHeader = jQuery('.component-tab .panel-group .panel-heading a');
        this.tabTitle = jQuery('.component-tab .panel-group .panel-heading .panel-title');

        this.registerEvents();

        this.tabHeader.eq(0).parent().addClass('open');
    }

    TabHandler.prototype.registerEvents = function () {
        var that = this;
        jQuery(this.tabHeader).on('click', function () {
            if (!resizeHandler.respondToEquals('xs')) {
                if (jQuery(this).parent().hasClass('open')) {
                    return false;
                } else {
                    jQuery(that.tabHeader).parent().removeClass('open');
                    jQuery(this).parent().addClass('open');
                }
            } else {
                    jQuery(that.tabHeader).parent().removeClass('open');
                    jQuery(this).parent().addClass('open');
            }
        });
    }
    
    return TabHandler;
}());