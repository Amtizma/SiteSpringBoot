function redirectToAllGames() {
    window.location.href = "/allgames";
}
function redirectToPCGames() {
    window.location.href = "/pc";
}
function redirectToXboxGames() {
    window.location.href = "/xbox";
}
function redirectToPlaystationGames() {
    window.location.href = "/ps";
}
function searchGame(){
    window.location.href = "/allgames?name="+document.getElementById("searchinput").value;
}
function redirectToGamePage(element) {
    const name = element.getElementsByClassName("gamename")[0].textContent;
    const encodedName = encodeURIComponent(name);
    window.location.href = "http://localhost:8080/game/" + encodedName;
}
