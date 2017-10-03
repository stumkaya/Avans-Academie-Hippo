
var GoogleMaps = (function () {

    function GoogleMaps() {
        this.map;
        this.center; 
        this.location;

        if (jQuery('#googlemap').length > 0) {
            this.initMap();
            this.registerResize();
        }
    }
    
    GoogleMaps.prototype.initMap = function () {
        this.center = new google.maps.LatLng(51.68941652,5.28970957);
        this.location = new google.maps.LatLng(51.68949134,5.29414326);

        var myOptions = {
            zoom:16,
            center: this.center,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            disableDefaultUI: true,
            scrollwheel: false,
            draggable: false,
            zoomControl: false,
            scaleControl: false,
            disableDoubleClickZoom: true,
            clickableIcons: false
        };
            
        this.map = new google.maps.Map(document.getElementById('googlemap'), myOptions);
        var marker = new google.maps.Marker({
            map: this.map,
            position: this.location
        });

        this.centerMap();
    }

    GoogleMaps.prototype.centerMap = function() {
        if (resizeHandler.respondToEquals('xs')) {
            this.map.panTo(this.location);
        } else {
            this.map.panTo(this.center);
        }
    }

    GoogleMaps.prototype.registerResize = function () {
        resizeHandler.register(function () {
            googleMaps.centerMap();
        });
    };

    return GoogleMaps;
}());