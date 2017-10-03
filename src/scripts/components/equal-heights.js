
var EqualHeights = (function () {

    /*
        The selectors takes an array of selector objects. A selector object is defined as follows:

        { "container": ".my-container", "target", ".my-target"}

        Please note that target specifies a child of the container. Ie. .cards contains .card elements.
    */

    function EqualHeights(selectors) {
        this.selectors = [];
        if (selectors)
            this.selectors = selectors;
        this.running = false;
        
        if (this.selectors.length > 0) {
            this.registerResize();
        }
    }

    EqualHeights.prototype.processSelectors = function () {
        if (!equalHeights.running) {
            equalHeights.running = true;
            setTimeout(equalHeights.run, 66);
        }
    };

    EqualHeights.prototype.run = function () {
        equalHeights.selectors.forEach(function (selector) {
            equalHeights.processSelector(selector);
        });
        equalHeights.running = false;
    };

    EqualHeights.prototype.processSelector = function(selector) {
        jQuery(selector['container']).each(function(i, container) {
            if (!resizeHandler.respondToEquals('xs')) {
                var height = 0;
                jQuery(selector['target'], container).each(function(j, card) {
                    if (height < jQuery(card).height())
                        height = jQuery(card).height();
                });
                jQuery(selector['target'], container).height(height);
            } else {
                jQuery(selector['target'], container).height('');
            }
        });
    }

    EqualHeights.prototype.add = function (selector) {
        if (selector) {
            if (this.selectors.length === 0) 
                equalHeights.registerResize();

            this.selectors.push(selector);
            this.processSelector(selector);
        }
    };
    
    EqualHeights.prototype.registerResize = function () {
        resizeHandler.register(function () {
            equalHeights.processSelectors();
        });
    };

    return EqualHeights;
}());