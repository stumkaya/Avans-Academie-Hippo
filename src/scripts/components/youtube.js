
var YouTube = (function () {

    function YouTube() {
        this.videos = jQuery('.video');
        this.hero = jQuery('.video-banner .video');
        this.players = [];
        this.heroVideo;

        if (this.videos.length > 0) {
            this.registerYouTube();

            if (this.hero.length > 0) {
                this.registerResize();
            }
        }
    }

    YouTube.prototype.setHeroVideo = function() {
        var videoWidth = jQuery(window).width()+200,
            videoHeight = jQuery(window).height()+200;

        if (videoWidth/videoHeight > 16/9) {
            this.heroVideo.setSize(videoWidth, videoWidth/16*9);
            this.hero.css({'left': '0px'});
        } else {
            this.heroVideo.setSize(videoHeight/9*16, videoHeight);
            this.hero.css({'left': -(this.hero.outerWidth()-videoWidth)/2});
        }
    }

    YouTube.prototype.registerYouTube = function () {
        var tag = document.createElement('script');
        tag.src = "https://www.youtube.com/iframe_api";

        var firstScriptTag = document.getElementsByTagName('script')[0];
        firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
    }

    YouTube.prototype.playerStateChange = function(event) {
        if (event.data == 0) {
            youTube.heroVideo.seekTo(0);
            //youTube.heroVideo.play();
        }
    }
    
    YouTube.prototype.registerResize = function() {
        var that = this;
        resizeHandler.register(function () {
            that.setHeroVideo();
        });
    }

    return YouTube;
}());

function onYouTubeIframeAPIReady() {
    youTube.videos.each(function(j, video) {
        var playerVars = {
            'showInfo': 0,
            'rel': 0,
        };
        if (jQuery(video).parent().hasClass('video-banner')) {

            if (!resizeHandler.respondToEquals('xs')) {
                playerVars['autoplay'] = 1;
                playerVars['controls'] = 0;
                playerVars['disablekb'] = 1;
                playerVars['iv_load_policy'] = 3;
                playerVars['loop'] = 1

                youTube.heroVideo = new YT.Player(jQuery(video)[0], {
                    playerVars: playerVars,
                    videoId: jQuery(video).data('video'),
                    events: {
                        'onStateChange': youTube.playerStateChange
                    }
                });

                youTube.setHeroVideo();
            } else {
                // destroy video?
            }
        } else {
            youTube.players.push(new YT.Player(jQuery(video)[0], {
                playerVars: playerVars,
                videoId: jQuery(video).data('video')
            }));
        }
    });
}