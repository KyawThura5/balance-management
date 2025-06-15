
document.addEventListener('DOMContentLoaded', () => {

	const regionSelect = document.getElementById('region');
	const districtSelect = document.getElementById('district');
	const townshipSelect = document.getElementById('township');
	
	if(regionSelect && districtSelect && townshipSelect){
		regionSelect.addEventListener('change', () =>{
			
			console.log(`Selected Region : ${regionSelect.value}`);
		})
	}
});
