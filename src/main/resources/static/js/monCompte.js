$(function()
{
	$("#changerMdp").click(afficherMessageValidationMdp);
	$("#saveChangesMonComtpe").click(enregistrerChangements);
});

function afficherMessageValidationMdp()
{
	var text = validerMdp();
    $("#passwordSpan").text(text);
}

function validerMdp()
{
	var password = $("#password").val().trim();
	var confirmPassword = $("#confirmPassword").val().trim();
	var text = "";

	if(password.length>0 && confirmPassword.length>0)
	{
		if(password === confirmPassword)
		{
			var id = $("#userInfo").attr("data-iduser");
			var newPassword = $("#newPassword").val();

            $.get("/ent/users/"+id+"/password",
				{
                    password : password
                },function(res)
				{
                    if(!res)
                    {
                        $("#passwordSpan").text("Erreur lors de la saisie du mot de passe");
                        $("#rightFormContainerLabel").find("input").val("");
                    }
                    else
                    {
                        if(newPassword.length<4)
                        {
                            $("#passwordSpan").text("Le nouveau mot de passe saisi est trop court (5 caractères min.)");
                            $("#rightFormContainerLabel").find("input").val("");
                        }
                        else
                        {
                            $.ajax({
                                url: "/ent/users/"+id+"/password",
                                data: {
                                    newPassword : newPassword
                                },
                                type:"PUT",
                                success: function (res) {
                                    $("#passwordSpan").text(res ? "Le changement a été enregistré" : "Echec lors de la mise à jour");
                                    $("#rightFormContainerLabel").find("input").val("");
                                },
                                error: function (res) {
                                    alert("Erreur : monCompte.js::35");
                                    $("#rightFormContainerLabel").find("input").val("");
                                }
                            });
                        }
                    }
				});
        }
		else
			return "Les champs saisis sont différents";
	}
	else
		return "Veuillez remplir tous les champs";
}

function enregistrerChangements()
{
    var email = $("#email").val().trim();
    var file = $("#file").val().trim();
    var id = $("#userInfo").attr("data-iduser");

    // TODO : nécessité verification présence file
    if(email.length>0)// && file.length>0)
	{
        $.ajax({
            url: "/ent/users/"+id,
            data: {
                email : email,
				file : "test"
            },
            type:"POST",
            success: function (res) {
                $("#saveSpan").text(res == -1 ? "Cette adresse mail est déjà utilisée par un autre utilisateur" : 1 ? "Les changements ont été enregistrés" : "Echec lors de l'enregistrement des changements");
            },
            error: function (res) {
                alert("Erreur : monCompte.js::79");
            }
        });
	}
	else
    	$("#saveSpan").text("Veuillez remplir tous les champs");
}