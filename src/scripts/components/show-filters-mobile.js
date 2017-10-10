(function() {
	var filtersVisible = false;
	var toggleFilter = jQuery('.toggle-filter');
	var showFilterButton = jQuery('.show-filter-button');
	var deleteFilterButton = jQuery('.delete-filter-button');
	var arrow = jQuery(toggleFilter).find('.arrow');
	var filterList = jQuery('.education-filters');
	function checkFilters() {
		if ($('input[name=interessegebied]:checked').length > 0) {
			deleteFilterButton.show();
		} else {
			deleteFilterButton.hide();
		}
	}
	showFilterButton.on('click', function() {
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
	deleteFilterButton.on('click', function(){
		$('input[name=interessegebied]').prop('checked', false);
		$(this).hide();
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
	$('input[name=interessegebied]').on('change', function(){
		checkFilters();
	});
	jQuery(document).ready(function() {
		checkFilters();
	});
})();