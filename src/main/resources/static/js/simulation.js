$(function()
{
	//TODO : gérer nombres décimaux
	$("#saveNotes").click(function()
	{
		alert("Enregistrer notes");
	});

	setCoefficientsUe();
	$("#calculerNotes").click(calculerMoyenne);

	$(".matiere").click(function()
	{

		var isEditable = $(this).find("editable").length == 0;
		if(isEditable)
		{
			updateCell();
			var note = parseFloat($(this).find(".noteMatiere").text());

			var input = "<input style='width=3%' type='text' value='"+note+"'>";
			$(this).find(".noteMatiere").text("").addClass("editable").append(input);
		}
		else
			alert("mode edition deja activé");
	});
});

//Supprimer la cellule editable et la remplace par une simple cellule
function updateCell()
{
	console.log("updateCell");
	if($(".editable").length == 1)
	{
		var value = $(".editable input").val();
		var validInput = value<=20 && value>=0;
		var editedMark = validInput ? value : 0;
		$(".editable").find("input").remove();
		$(".editable").closest(".noteMatiere").text(editedMark);
		$(".editable").removeClass("editable");
	}
}

function setCoefficientsUe()
{
	console.log("setCoefficientsUe");
	$(".ue").each(function()
	{
		var totalCoef = 0;
		var ue = $(this);
		var ueId = ue.attr("data-ue");

		$(".matiere[data-ue="+ueId+"]").each(function()
		{
			var coef = parseFloat($(this).find(".coefficientMatiere").text());
			totalCoef += coef;
		});

		ue.find(".coefficientUE b").text(totalCoef);
	});
}

function calculerMoyenneUe()
{
	console.log("calculerMoyenne");

	updateCell();

	if(!validerNotes())
	{
		$(".ue").each(function()
		{
			var totalNotes = 0;
			var moyenneUE = 0;

			var ue = $(this);
			var ueId = ue.attr("data-ue");
			var totalCoef = parseFloat(ue.find(".coefficientUE b").text());

			// alert("totalCoef : "+totalCoef);

			$(".matiere[data-ue="+ueId+"]").each(function()
			{
				var note = parseFloat($(this).find(".noteMatiere").text());
				var coef = parseFloat($(this).find(".coefficientMatiere").text())

				moyenneUE += note*coef;
				totalNotes += note;
			});

			moyenneUE /= totalCoef;
			ue.find(".moyenneUE b").text(moyenneUE);
		});
	}
};

function validerNotes()
{
	console.log("validerNotes");
	var hasInvalidMarks = false;

	$(".noteMatiere").each(function()
	{
		var note = $(this).text();
		var matiere = $(this).closest(".matiere").find("td").eq(0).text();
		if(note>20 || note<0)
		{
			alert("note invalide : "+note+"\n matiere : "+matiere);
			hasInvalidMarks=true;
		}
	});

	return hasInvalidMarks
}

function calculerMoyenneSemestre()
{
	console.log("calculerMoyenneSemestre");
	var totalNotes = 0;
	var moyenneSemestre = 0;
	var totalCoef = 0;

	$(".ue").each(function()
	{
		var ue = $(this);
		var ueId = ue.attr("data-ue");
		
		totalCoef += parseFloat(ue.find(".coefficientUE").text());

		// alert("totalCoef : "+totalCoef);

		var moyenneUE = parseFloat($(this).find(".moyenneUE").text());
		var coefUE = parseFloat($(this).find(".coefficientUE").text());

		moyenneSemestre += moyenneUE*coefUE;
		
	});

	console.log("moyenneSemestre : "+moyenneSemestre);
	console.log("totalCoef : "+totalCoef);
	moyenneSemestre /= totalCoef;
	$(".moyenneSemestre b").text(moyenneSemestre);
	$(".total").show();
};

function calculerMoyenne()
{
	console.log("calculerMoyenne");
	calculerMoyenneUe();
	calculerMoyenneSemestre();
}
