$(document).ready(function () {
    $(".owl-carousel").owlCarousel({
        nav:true,
        dots:false,
        loop:true,
        center:true,
        autoWidth:true,
        navClass: [
            'streamer__nav--prev',
            'streamer__nav--next'
        ]
    });

    $(".owl-nav").removeClass('disabled')
});