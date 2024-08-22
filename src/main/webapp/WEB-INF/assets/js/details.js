
function confermaEliminazione() {
	return confirm("Sei sicuro di voler eliminare questo treno?");
}

function toggleForm() {
	var form = document.getElementById("modificaTrenoForm");
	form.classList.toggle("hidden");
}
