(function() {
	var heroAfter = $('.hero-after');
	var heroText = $('.text.hero-text');
	function setHeroAfterHeight() {
		var heroTextHeight = heroText.height();
		if ($(document).width() < 992) {
			heroAfter.height(heroTextHeight);
		}
	}
	jQuery(document).ready(function () {
		setHeroAfterHeight();
	});
	window.onresize = function() {
		setHeroAfterHeight();
	}
})();