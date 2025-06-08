document.addEventListener('DOMContentLoaded', () => {
	const searchForm = document.getElementById('searchForm');
	const pageInput = document.getElementById('pageInput');
	const sizeInput = document.getElementById('sizeInput');
	const sizeSelect = document.getElementById('sizeSelect');

	if (searchForm && pageInput && sizeInput) {
		
		// Handle size change
		sizeSelect.addEventListener('change', () => {
			sizeInput.value = sizeSelect.value;
			pageInput.value = '0';
			searchForm.submit();
		});

		// Handle page link clicks
		Array.from(document.getElementsByClassName('pageLink')).forEach(pageLink => {
			pageLink.addEventListener('click', (event) => {
				event.preventDefault(); //Important: call the function with ()
				
				const page = pageLink.getAttribute('data-page-number');
				pageInput.value = page;
				searchForm.submit(); //Submit the form with new page value
			});
		});
	}
});
