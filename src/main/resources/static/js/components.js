/**
 * Created by ranox on 31/05/17.
 */
$(function()
{
    $(".tabs li").click(function()
    {
        if($(this).is(".mainMenuItem"))
        {
            $("#mainMenuContainer").show();
            $("#rightMenuContainer").hide();
        }
        else
        {
            $("#mainMenuContainer").hide();
            $("#rightMenuContainer").show();
        }
    });

    $("#maClasseMenuTab").click(loadMaClasseContainer());
    $("#mesCoursMenuTab").click(loadMesCoursContainer());
    $("#mesFichiersMenuTab").click(loadMesFichiersContainer());

    $("#monCompteMenuTab").click(loadMonCompteContainer());
    $("#messagerieMenuTab").click(loadMessagerieContainer());
});

function loadMaClasseContainer()
{
    $("#mainMenuContainer").show();
    $("#rightMenuContainer").hide();
}

function loadMesCoursContainer()
{
    $("#mainMenuContainer").show();
    $("#rightMenuContainer").hide();
}

function loadMesFichiersContainer()
{
    $("#mainMenuContainer").show();
    $("#rightMenuContainer").hide();
}

function loadSimulateurContainer()
{
    $("#mainMenuContainer").show();
    $("#rightMenuContainer").hide();
}

function loadMessagerieContainer()
{
    $("#mainMenuContainer").hide();
    $("#rightMenuContainer").show();
}

function loadMonCompteContainer()
{
    $("#mainMenuContainer").hide();
    $("#rightMenuContainer").show();
}
