document.addEventListener('DOMContentLoaded', function() {
    var trenoImageContainer = document.getElementById('treno-image-container');
    var trenoData = document.getElementById('treno-data');
    var trenoCompagnia = trenoData.getAttribute('data-compagnia');
    
    console.log('Compagnia:', trenoCompagnia); 

    var trenoImage = document.createElement('img');
    trenoImage.alt = 'Immagine Treno';
    trenoImage.style.maxWidth = '100%';
    trenoImage.style.height = 'auto';

    switch(trenoCompagnia) {
        case 'FR':
            trenoImage.src = '${pageContext.request.contextPath}/resources/img/frecciarossa.jpeg';
            break;
        case 'IT':
            trenoImage.src = '${pageContext.request.contextPath}/resources/img/italo.jpeg';
            break;
        case 'TN':
            trenoImage.src = '${pageContext.request.contextPath}/resources/img/trenord.jpeg';
            break;
        default:
            trenoImage.src = '${pageContext.request.contextPath}/resources/img/default.jpg';
    }

    trenoImageContainer.appendChild(trenoImage);
});


function confermaEliminazione() {
	return confirm("Sei sicuro di voler eliminare questo treno?");
}

function toggleForm() {
	var form = document.getElementById("modificaTrenoForm");
	form.classList.toggle("hidden");
}