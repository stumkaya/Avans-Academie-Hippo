"use strict";

var resizeHandler, scrollHandler, cookieBox, searchBox, 
    mainMenu, heroBanner, equalHeights, quickNav, tabHandler,
    slider, youTube, googleMaps, detailsSlider;

jQuery(document).ready(function () {
    resizeHandler = new ResizeHandler();
    scrollHandler = new ScrollHandler();

    cookieBox = new CookieBox();
    searchBox = new SearchBox();
    mainMenu = new MainMenu();
    heroBanner = new HeroBanner();
    equalHeights = new EqualHeights([{ "container": ".cards", "target": ".card" }]);
    equalHeights.processSelectors();
    quickNav = new QuickNav();
    tabHandler = new TabHandler();
    slider = new Slider();
    youTube = new YouTube();
    detailsSlider = new DetailsSlider();

    console.log('google maps');
});

// The previous version was too fast and didnt get called correctly
function initMap(){
    $(document).ready(function () {
        googleMaps = new GoogleMaps();

    });
}
