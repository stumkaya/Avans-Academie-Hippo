
var SearchBox = (function () {

    function SearchBox() {
        this.searchToggle = jQuery('.search-toggle');
        this.searchBox = jQuery('.search-box');

        if (this.searchBox.length > 0) {
            this.registerEvents();
        }
    }

    SearchBox.prototype.registerEvents = function () {
        var that = this;
        jQuery(this.searchToggle).on('click', function () {
            jQuery(that.searchBox).toggleClass('show');
            return false;
        });
    }
    
    return SearchBox;
}());