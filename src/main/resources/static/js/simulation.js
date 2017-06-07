$(function()
{
	//TODO : gérer nombres décimaux
	$("#saveNotes").click(function()
	{
		alert("Enregistrer notes");
	});

	setCoefficientsUe();
	$("#calculerNotes").click(calculerMoyenne);

	$("#marksTable").on("click",".matiere",function()
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

    $("#topContainerTermsList").on("click", ".list-group-item", function()
    {
    	$(".active").removeClass("active");
    	$(this).addClass("active");

        $("#marksTable, #emptyUeTable").hide();
        var id = $(this).attr("id");
        // alert($(this).text()+" => id : "+id);

        $.ajax({
            url: "/ent/simulateur/semestres/"+id,
            type:"GET",
            success: function (res) {

            	if(res.length==0)
				{
                    $("#emptyUeTable").show();
                    $("#actions").hide();
                }
            	else
				{
                    var table = "";

                    for (var i = 0; i <= res.length - 1; i++) {
                        var ue = res[i];
                        table += "<tr class='ue' data-ue='" + ue.id + "'>" +
                            "<td><b>" + ue.nom_ue + "</b></td>" +
                            "<td class='coefficientUE'><b></b></td>" +
                            "<td class='moyenneUE'><b></b></td></tr>";

                        // getMatieres(table, ue.id);
                    }

                    table += "<tr class='total'>" +
                        "<td></td><td></td>" +
                        "<td class='moyenneSemestre'><b></b></td></tr>";

                    $("#emptyUeTable").hide();
                    $("#actions, #marksTable").show();
                    $("#marksTable").find("tbody").html(table);
                    peuplerTableauMatieres();
                }
            },
            error: function (res) {
                alert("Erreur : simulation.js::28");
            }
        });
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

function peuplerTableauMatieres()
{
	$(".ue").each(function()
	{
		var idUe = $(this).attr("data-ue");
        getMatieres(idUe);
	});
}

function getMatieres(idUe)
{
    $.ajax({
        url: "/ent/simulateur/matieres/"+idUe,
        type:"GET",
        success: function (res) {

        	var matieres = res;
			var lignesTableau = "";
			var totalEcts = 0;

			for(var j =0;j <= matieres.length-1;j++)
			{
				var matiere = matieres[j];

				totalEcts += matiere.nb_ects;
                lignesTableau += "<tr class='matiere' data-matiere='"+matiere.id+"' data-ue='"+idUe+"'>" +
					"<td>"+matiere.nom_matiere+"</td>" +
					"<td class='coefficientMatiere'>"+matiere.nb_ects+"</td>" +
					"<td class='noteMatiere input-field'>0</td></tr>";
			}

            $("#marksTable").find("tr[data-ue='" + idUe + "']").after(lignesTableau).show();
            $("#marksTable").find("tr[data-ue='" + idUe + "']").find(".coefficientUE>b").text(totalEcts);
        },
        error: function (res) {
            alert("Erreur : simulation.js::28");
        }
	});
}