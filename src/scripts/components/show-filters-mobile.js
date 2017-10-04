(function() {
	var filtersVisible = false;
	var toggleFilter = jQuery('.toggle-filter');
	var arrow = jQuery(toggleFilter).find('.arrow');
	var filterList = jQuery('.education-list');
	toggleFilter.on('click', function() {
		if (!filtersVisible) {
			filterList.slideDown(200);
			arrow
				.removeClass('down')
				.addClass('up');
			filtersVisible = true;
		} else {
			filterList.slideUp(200);
			arrow
				.removeClass('up')
				.addClass('down');
			filtersVisible = false;
		}
		return false;
	});
	jQuery(window).resize(function() {
		if (toggleFilter.css('display') == 'none') {
			filterList.show();
		} else {
			if (filtersVisible) {
				filterList.show();
			} else {
				filterList.hide();
			}
		}
	});
})();