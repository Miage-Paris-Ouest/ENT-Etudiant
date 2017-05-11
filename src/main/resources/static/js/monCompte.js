$(function()
{
	$("#changerMdp").click(validerMdp);
	$("#saveChangesMonComtpe").click(enregistrerChangements);
});

function validerMdp()
{
	var password = $("#password").val();
	var confirmPassword = $("#confirmPassword").val();
	var text = "";

	if(password.length>0 && confirmPassword.length>0)
	{
		if(password === confirmPassword)
		{
			var id = $("#userInfo").attr("data-iduser");
			var newPassword = $("#newPassword").val();

            $.get("/users/"+id+"/password",
				{
                    password : password
                },function(res)
				{
                    if(newPassword.length>4)
                    {
                        $.post("/users/"+id+"/password",
                            {
                                password : password,
                                newPassword : newPassword
                            },function (res) {
                                text = res ? "Le changement a été enregistré" : "Echec lors de la mise à jour"
                            })
                    }
                    else
                        text = "Le nouveau mot de passe saisi est trop court (5 caractères min.)";
                });
        }
		else
			text = "Les champs saisis sont différents";
	}
	else
		text = "Veuillez remplir tous les champs";

	$("#passwordSpan").text(text);
}

function enregistrerChangements()
{
	alert("enregistrerChangements");
}