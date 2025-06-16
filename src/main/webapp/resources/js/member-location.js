
document.addEventListener('DOMContentLoaded', () => {

	const regionSelect = document.getElementById('region');
	const districtSelect = document.getElementById('district');
	const townshipSelect = document.getElementById('township');
	
	const selectOneOption = () => {
				const option = document.createElement('option');
				option.innerText = "Select One";
				option.value = "";
				return option;
			};

	if (regionSelect && districtSelect && townshipSelect) {

		
		//Get district  from changed region id 
			regionSelect.addEventListener('change', () => {

				const regionId = regionSelect.value;
				if (regionId) {

					console.log(`Selected Region : ${regionId}`);

					const fetchApi = `${regionSelect.dataset['fetchApi']}?regionId=${regionId}`
					console.log(`fetchApi : ${fetchApi}`)

					fetch(fetchApi).then(async (response) => {

						const result = await response.json();

						console.log(result);

						setDistrict(result);
					})
				} else {
					
					setDistrict()
				}
			})


			//Get township from changed district id
			districtSelect.addEventListener('change', () => {
				const districtId = districtSelect.value;
				if (districtId) {

					const fetchApi = `${districtSelect.dataset['fetchApi']}?districtId=${districtId}`

					fetch(fetchApi).then(async (response) => {

						const result = await response.json()
						
						console.log(result)

						setTownship(result)
					})
				}else{
					setTownship()
				}
			})

		//Get selected region of District
		const setDistrict = (result) => {
			
			//clear selected district
			Array.from(districtSelect.children).forEach(option => {
				districtSelect.removeChild(option)
			})
			districtSelect.appendChild(selectOneOption())
			
			//clear selected township
			Array.from(townshipSelect.children).forEach(option => {
									townshipSelect.removeChild(option)

			})
			townshipSelect.appendChild(selectOneOption())
			
			//to show district from selected region 
			if (result) {
				Array.from(result).map(item => {
					const option = document.createElement('option')
					option.value = item.id
					option.innerText = item.name
					return option;
				}).forEach(option => {
					districtSelect.appendChild(option)
				})
			}
			
		}
		
		//Get selected District of Township
				const setTownship = (result) => {
					Array.from(townshipSelect.children).forEach(option => {
						townshipSelect.removeChild(option)

					})
					townshipSelect.appendChild(selectOneOption())
					
					if (result) {
						Array.from(result).map(item => {
							const option = document.createElement('option')
							option.id = item.id
							option.innerText = item.name
							return option;

						}).forEach(option => {

							townshipSelect.appendChild(option)
						})
					}
				}
	}
});
