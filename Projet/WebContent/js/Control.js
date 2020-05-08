/**
 * 
 */

$(document).ready(function() {
	loadMain();
});

function loadMain() {
	$("#Main").load("Main.html", function() {
		client = {};
		compte = {};
		$("#BTInscription").click(function() {
				loadAddClient(client,compte);
						
		});
		
		$("#BTIdentification").click(function() {
			loadIdentification(compte);
					
		});
		
		$("#BTList").click(function() {
			loadList();
		});
	});
}

function loadAddClient(){
	$("#ShowMessage").empty();
	$("#Main").load("AddInscription.html", function() {		
		
		
		$("#BTVSuivant").click(function() {
			
			client = {};
			client.nom=$("#nom").val();
			client.prenom=$("#prenom").val();				
			invokePost("rest/addClient", client, "client was added", "failed to add a client");
			
			loadAddCompte(client);
			
			
		});

	});
}

function loadList(){
	$("#ShowMessage").empty();
	$("#Main").load("ListProduits.html", function() {
		/*invokeGet("rest/listProduits", "failed to list products", function(response) {			
		});*/
		
		for (var i=0;i<8;i++){
		$("#ListOfProducts").append( "<div class=p-flex><div class=p-flex-in> \n " +
				"  <img  class=p-img src=images/shopping.png />" +
				"  <div class=p-name>nom du prdouit</div> \n" +
				"  <div class=p-price>€prix</div> \n" +
				"  <div class=p-desc>description</div> \n " +
				"  <button class=p-add>Acheter</button> \n" +
				"</div></div>");
		}
		/*$("#flex").append("<div class=p-flex><div class=p-flex-in>");	
		$("#flex").append("  "+"<img class=p-img src=images/pic01.jpg/>");
		$("#flex").append("  "+"<div class=p-name>nom du prdouit</div>");
		$("#flex").append("  "+"<div class=p-price>€prix</div>");
		$("#flex").append("  "+"<div class=p-desc>description</div>");
		$("#flex").append("  "+"<button class=p-add>Acheter</button>");
		$("#flex").append("</div></div>");*/

	});
	
}


function loadIdentification(compte){
	$("#ShowMessage").empty();
	$("#Main").load("Identification.html", function() {	
		
		$("#BTConnect").click(function() {
					
			compte.username=$("#nom").val();
			compte.password=$("#mdp").val();
			//loadMain();
			loadverification(compte);
			//invokePost("rest/addClient", client, "client was added", "failed to add a client");			
			
		});
		
		$("#BTreturn").click(function() {

			loadMain();
			
		});
		$("#BTinscription").click(function() {
			
			loadAddClient();
			
		});

	});
}

function loadverification(compte) {
	$("#ShowMessage").empty();
	listcomptes = invokeGet("rest/listComptes", "failed to list comptes", function(response) {
		listcomptes = response;
		if (listcomptes == null) return;

		for (var i=0; i < listcomptes.length; i++) {
			var courant = listcomptes[i];
			if (courant.username === compte.username) {
				if (courant.password === compte.password ) {
					swal("Bienvenue !", courant.owner.nom , courant.owner.prenom);
				} else {
			        $(this).css({ // on rend le champ rouge
			 	        borderColor : 'red',
			    	color : 'red'
			        });
				}
			}
			else {
		        $(this).css({ // on rend le champ rouge
		 	        borderColor : 'red',
		    	color : 'red'
		        });
			}
		}
	});
}

function confirmer(mdp,cmdp){
	if($mdp.val() != $mdp.val()){ // si la confirmation est différente du mot de passe
        $(this).css({ // on rend le champ rouge
 	        borderColor : 'red',
    	color : 'red'
        });
    }
    else{
	    $(this).css({ // si tout est bon, on le rend vert
	        borderColor : 'green',
	        color : 'green'
	    });
    }
}
   


function loadAddCompte(client) {

	$("#Main").load("AddCompte.html", function() {
		
		var $champ = $('.champ');	
	
		// le code précédent se trouve ici
	
		$champ.keyup(function(){
			
		    if($(this).val().length < 8){ // si la chaîne de caractères est inférieure à 5
		        $(this).css({ // on rend le champ rouge
		            borderColor : 'red',
			    color : 'red'
		        });
		     }
		     else{
		         $(this).css({ // si tout est bon, on le rend vert
			     borderColor : 'green',
			     color : 'green'
			 });
		     }
		});
	
	
		$("#BTVCompte").click(function() {				

			    compte = {};
				compte.username=$("#username").val();
				compte.password=$("#password").val();
						
				
				invokePost("rest/addCompte", compte, "compte was added", "failed to add a compte");
				loadAddAssociation(client,compte);
				
				
				//loadCompte(client,compte);
				//invokePost("rest/associate", client, compte, "association was added", "failed to add an association");
				//loadMain();
				//("rest/associate", ass, "association was created", "failed to create association");
				//loadMain();
			
			
		});
		$("#BTVFinir").click(function() {
			loadAddAssociation(client,compte);
		});
		
	});
}


function loadAddAssociation(client,compte) {
	ass = {};
	ass.ClientId=1;
	ass.CompteId=2;
	
	//var dataId = $(compte).attr("id");
	//afficherPopupInformation(dataId);
	
	invokePost("rest/associate", compte, client, "association was created", "failed to create association");
	loadMain();
}

function invokePost(url, data, successMsg, failureMsg) {
	jQuery.ajax({
	    url: url,
	    type: "POST",
	    data: JSON.stringify(data),
	    dataType: "json",
	    contentType: "application/json; charset=utf-8",
	    success: function (response) {
	    	$("#ShowMessage").text(successMsg);
	    },
	    error: function (response) {
	    	$("#ShowMessage").text(failureMsg);
	    }
	});
}
function invokeGet(url, failureMsg, responseHandler) {
	jQuery.ajax({
	    url: url,
	    type: "GET",
	    success: responseHandler,
	    error: function (response) {
	    	$("#ShowMessage").text(failureMsg);
	    }
	});
}



function afficherPopupInformation(message) {

	 // crée la division qui sera convertie en popup

	 $('body').append('<div id="popupinformation" title="Information"></div>');

	 $("#popupinformation").html(message);



	 // transforme la division en popup

	 var popup = $("#popupinformation").dialog({

	     autoOpen: true,

	     width: 400,

	     dialogClass: 'dialogstyleperso',

	     buttons: [

	         {

	             text: "OK",

	             "class": 'ui-state-information',

	             click: function () {

	                 $(this).dialog("close");

	                 $('#popupinformation').remove();

	             }

	         }

	     ]

	 });



	 // ajouter le style à la barre de titre

	 // note : on n'utilise pas .dialogClass dans la définition de la boîte de dialogue car mettrait tout le fond en couleur

	 $("#popupinformation").prev().addClass('ui-state-information');



	 return popup;

	}



/*
function loadInscription() {
$("#ShowMessage").empty();
$("#Main").load("AddInscription.html", function() {
	$("#BTVInscription").click(function() {
		client = {};
		client.nom=$("#nom").val();
		client.prenom=$("#prenom").val();		

		invokePost("rest/addClient", client, "client was added", "failed to add a client");
		
		compte = {};
		compte.username=$("#username").val();
		compte.password=$("#password").val();		
		
		
		ass = {};
		ass.clientId= invokeGet("rest/idClient", client,"failed to id client", function(response) {
			ass.clientId= response;});				
		ass.compteId=invokeGet("rest/idCompte",compte, "failed to id compte", function(response) {
			ass.compteId= response;});
		
		
		invokePost("rest/addCompte", compte, "compte was added", "failed to add a compte");
		invokePost("rest/associate", ass, "association was created", "failed to create association");
	
	});
	$("#BTVMain").click(function() {
		loadMain();
	});
});
}

*/