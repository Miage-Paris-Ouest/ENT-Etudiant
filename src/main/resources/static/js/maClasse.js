/**
 * Created by ranox on 07/06/17.
 */
$(function()
{
    populateFilesForClass();
});

function populateFilesForClass()
{
    // alert("Promo id : "+$("#classInfo").attr("data-id"))
    //TODO : get idClasse

    // var idClasse = $("#classInfo").attr("data-id");

    // $.ajax({
    //     url: "/ent/fichiers/classes",
    //     type:"GET",
    //     success: function (res) {
    //
    //         var fichiers = res;
    //         var lignes = "";
    //         for(var j =0;j <= fichiers.length-1;j++)
    //         {
    //             var fichier = fichiers[j];
    //
    //             lignes += "<li class='list-group-item'><span class='nomUser'>User</span> a partagé un <b style='cursor:pointer' class='typeObjet'>fichier</b>pour le cours de <b class='liaisonObjet' style='cursor:pointer'>"+ fichier.id_matiere +
    //                 "</b> : <i class='titreObjet'>"+fichier.nom+"</i> <span class='date' style='float:right'><i class='date'>date</i></span></li>";
    //         }
    //
    //         $("#filesList").html(lignes);
    //     },
    //     error: function (res) {
    //         alert("Erreur : maClasse.js::10");
    //     }
    // });
}

