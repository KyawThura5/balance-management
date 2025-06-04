/**
 * 
 */
document.addEventListener('DOMContentLoaded',()=>{
	const signOutMenu = document.getElementById('signOutMenu')
	const signOutForm = document.getElementById('signOutForm')
	
	signOutMenu.addEventListener('click',(event)=>{
		event.preventDefault()
		signOutForm.submit()
	})
})