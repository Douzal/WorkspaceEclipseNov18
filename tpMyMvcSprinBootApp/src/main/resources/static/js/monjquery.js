$(function(){
	$('#btnRechercherBlagues').on('click', function() {
		// debut de la fon,ction callback anonyme enregistrée
		// sur le click sur le bouton dont l'id est btnRechercherBlagues
		console.log("---Bonjour de la Batte !");
		var valNoteMini = $('#txtNoteMini').val();
		// partie JQuery/Ajax
		$.ajax({
			Type:'GET',
			url:"./rest/blagues" + ((valNoteMini!=null) ? ("?noteMini=" + valNoteMini):""),
//			contentType:'application/json',
//			En cas de succes, fonction a effectuer :
			success:function(data, status, xhr){
				// dans cette version 'jquery', pas besoin de JSON.parse()
				// c'est déjà déclanché en interne si réponse application/JSon
//				console.log('---Data : '+data);
				$('#zoneListe').html("");

				var listeBlagues = data;
				for(var i = 0; i<listeBlagues.length; i++) {
					$('#zoneListe').append("<li>"+listeBlagues[i].texte+"</li>");
				}
				// on rajoute la liste de toutes les blagues en haut (en span d'id : spanMessage)
				$('#spanMessage').html(JSON.stringify(listeBlagues));
			},
			// s'il y a une erreur :
			error:function(jqXHR, textStatus, errorThrown){
				console.log('---sono perduti !!');
			}
		});

	});
});