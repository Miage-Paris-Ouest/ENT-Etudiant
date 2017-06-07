$(function () {

//TODO : admin>gestion des classes ajouter un étudiant

    $('ul.tabs').tabs();

    $('select').material_select();

    $(".modal").modal();

    $("#allCoursesList, #currentCoursesList").sortable({
        connectWith: ".connectedSortable",
        scroll: false
    }).disableSelection();

    $("#topContainerList .list-group-item").click(function () {
        $("#topContainerList .list-group-item.active").removeClass("active");
        $(this).addClass("active");

        $("#selectedClassLabel").text($(this).attr("data-code"));

        $("#studentsTable").find(".class").text($(this).attr("data-code"));

        $(".selectedStudent").removeClass("selectedStudent");
        $("#actionButtons").hide().removeClass("active");

    });

    $(".student").click(function () {
        $(".selectedStudent").removeClass("selectedStudent");
        $(this).addClass("selectedStudent");

        $("#actionButtons").show();
    });

    $("#deleteStudent").click(function () {
        //TODO : suppr BDD

        $(".selectedStudent").remove();
        $("#actionButtons").hide().removeClass("active");
    });

    $("#editStudent").click(function () {
        //TODO : suppr BDD

        $("#modalActionLabel").text("Mise à jour d'un étudiant");
        $("#actionButtons").hide();
        $("#classForm").hide();
        $("#studentForm").show();
        $("#validateActionButtonLabel").text("Enregistrer");

        $("#studentForm").find("input#nom").val($(".selectedStudent").find(".nom").text());
        $("#studentForm").find("input#prenom").val($(".selectedStudent").find(".prenom").text());
        $("#studentForm").find("label").addClass("active");

        //TODO : PRB selection
        var studentCurrentClass = $(".selectedStudent").find(".class").text();
        $('#studentForm option[value="' + studentCurrentClass + '"]').attr('selected', true);
    });

    $("#createClass").click(function () {
        $("#modalActionLabel").text("Création d'une classe");
        $("#classForm").show();
        $("#studentForm").hide();
        $("#validateActionButtonLabel").text("Créer");
    });

    $("#topContainerListAdminCourses .list-group-item").click(function () {
        $("#topContainerListAdminCourses .list-group-item.active").removeClass("active");
        $(this).addClass("active");

        $("#selectedClassLabel").text($(this).attr("data-code"));

        $("#studentsTable").find(".class").text($(this).attr("data-code"));

        $(".selectedStudent").removeClass("selectedStudent");
        $("#actionButtons").hide().removeClass("active");

    });

    $("#topContainerListAdminCourses>li").click(function () {
        alert("N'afficher que les matières du niveau de la promo (L3, M1, etc)");
        $("#selectedClassCoursesLabel").text("Liste des cours : " + $(this).attr("data-code"));
    });

    $("#saveChanges").click(function () {
        alert("Enregistrer les changements");
    });

    /** page maclasse */

    $('#addStudentButton').click(function () {
        $('#addStudentForm').show();
    });

});
