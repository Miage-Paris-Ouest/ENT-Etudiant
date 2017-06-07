/**
 * Created by ranox on 31/05/17.
 */
$(function()
{
    // $(".listContainer").mCustomScrollbar({
    //     theme: "dark"
    // });

    $("#accueilTab").click(function()
    {
        $(".activeTab").removeClass("activeTab");
        $("#calendrierContainer").addClass("activeTab");
    });

    $("#maClasseTab").click(function()
    {
        $(".activeTab").removeClass("activeTab");
        $("#maClasseContainer").addClass("activeTab");
    });

    $("#mesCoursTab").click(function()
    {
        $(".activeTab").removeClass("activeTab");
        $("#mesCoursContainer").addClass("activeTab");
    });

    $("#mesFichiersTab").click(function()
    {
        $(".activeTab").removeClass("activeTab");
        $("#mesFichiersContainer").addClass("activeTab");
    });

    $("#messagerieTab").click(function()
    {
        $(".activeTab").removeClass("activeTab");
        $("#messagerieContainer").addClass("activeTab");
    });

    $("#monCompteTab").click(function()
    {
        $(".activeTab").removeClass("activeTab");
        $("#monCompteContainer").addClass("activeTab");
    });

    $("#simulateurTab").click(function()
    {
        $("#marksTable, #actions").show();
        $(".activeTab").removeClass("activeTab");
        $("#simulateurContainer").addClass("activeTab");
    });
});

