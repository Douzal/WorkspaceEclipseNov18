$(function() {
	$('#btnAjouterBlague').on('click', function() {
		console.log('---Au revoir de la Batte !');
		
		
		var nouvelleBlague = {titre : '?', texte : '?'};
		nouvelleBlague.titre = $('#idTitre').val();
		nouvelleBlague.texte = $('#idTexte').val();
		
		console.log('--nouvelleBlague : ' +  JSON.stringify(nouvelleBlague));
		
		$.ajax({
			type : 'POST',
			url : './rest/blagues',
			data : JSON.stringify(nouvelleBlague),
			dataType : 'json',
			contentType : 'application/json',
			
//			En cas de succes, fonction a effectuer :
			success: function(data, status, xhr){
				console.log('---TU ES LE ROI DU MONDE - CIAO à plus ---');
				$('#spanMessage').html('Blague ajoutée : ' + JSON.stringify(data));
			},
			
			// s'il y a une erreur :
			error: function(jqXHR, textStatus, errorThrown){
				console.log('---sono perduti !!');
				console.log(textStatus);
				
			// a enlever
				var valNoteMini = $('#txtNoteMini').val();
				// partie JQuery/Ajax
				$.ajax({
					Type:'GET',
					url:"./rest/blagues" + ((valNoteMini!=null) ? ("?noteMini=" + valNoteMini):""),
//					contentType:'application/json',
//					En cas de succes, fonction a effectuer :
					success:function(data, status, xhr){
						// dans cette version 'jquery', pas besoin de JSON.parse()
						// c'est déjà déclanché en interne si réponse application/JSon
//						console.log('---Data : '+data);
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
				//a enlver
			}
		});

	});
});