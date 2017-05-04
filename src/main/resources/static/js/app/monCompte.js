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
			alert("MAJ mdp");
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