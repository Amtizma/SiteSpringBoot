$(document).ready(function(){
    $('#promodiv').slick({
        autoplay: true,
        autoplaySpeed: 4000,
        arrows: true,
        dots: true
    });
});
function redirectToActionGames() {
    window.location.href = "/allgames?genre=Action";
}
function redirectToAdventureGames() {
    window.location.href = "/allgames?genre=Adventure";
}
function redirectToRPGGames() {
    window.location.href = "/allgames?genre=RPG";
}
function redirectToShooterGames() {
    window.location.href = "/allgames?genre=Shooter";
}
function redirectToSportsCarsGames() {
    window.location.href = "/allgames?genre=Sports/Cars";
}
function redirectToOnlineGames() {
    window.location.href = "/allgames?genre=Online";
}
function redirectToSimulatorGames() {
    window.location.href = "/allgames?genre=Simulator";
}
function redirectToStrategyGames() {
    window.location.href = "/allgames?genre=Strategy";
}

