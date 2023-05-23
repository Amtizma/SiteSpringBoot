function filterByGenre(e) {
    const genre = e.textContent;
    if (window.location.href.includes("?")) {
        window.location.href =
            window.location.href.substring(
                0,
                window.location.href.lastIndexOf("?")
            ) + `?genre=${genre}`;
    } else window.location.href += `?genre=${genre}`;
}
function sortDefault(){
    if(window.location.href.includes("genre")) {
        const url = window.location.href.split('&');
        window.location.href = url[0];
    }
    if(window.location.href.includes("filter")) {
        const url = window.location.href.split('?');
        window.location.href = url[0];
    }
}
function sortByPriceASC(){
    if(window.location.href.includes("genre")) {
        const url = window.location.href.split('&');
        window.location.href = url[0] + "&filter=price&sortOrder=ASC";
    }
    else {
        if(window.location.href.includes("filter")) {
            const url = window.location.href.split('?');
            window.location.href = url[0] + "?filter=price&sortOrder=ASC";
        }
        else window.location.href += "?filter=price&sortOrder=ASC";
    }
}
function sortByNameASC(){
    if(window.location.href.includes("genre")) {
        const url = window.location.href.split('&');
        window.location.href = url[0] + "&filter=name&sortOrder=ASC";
    }
    else {
        if(window.location.href.includes("filter")) {
            const url = window.location.href.split('?');
            window.location.href = url[0] + "?filter=name&sortOrder=ASC";
        }
        else window.location.href += "?filter=name&sortOrder=ASC";
    }
}
function sortByReleaseDateASC(){
    if(window.location.href.includes("genre")) {
        const url = window.location.href.split('&');
        window.location.href = url[0] + "&filter=releaseDate&sortOrder=ASC";
    }
    else {
        if(window.location.href.includes("filter")) {
            const url = window.location.href.split('?');
            window.location.href = url[0] + "?filter=releaseDate&sortOrder=ASC";
        }
        else window.location.href += "?filter=releaseDate&sortOrder=ASC";
    }
}
function sortByPriceDESC(){
    if(window.location.href.includes("genre")) {
        const url = window.location.href.split('&');
        window.location.href = url[0] + "&filter=price&sortOrder=DESC";
    }
    else {
        if(window.location.href.includes("filter")) {
            const url = window.location.href.split('?');
            window.location.href = url[0] + "?filter=price&sortOrder=DESC";
        }
        else window.location.href += "?filter=price&sortOrder=DESC";
    }
}
function sortByNameDESC(){
    if(window.location.href.includes("genre")) {
        const url = window.location.href.split('&');
        window.location.href = url[0] + "&filter=name&sortOrder=DESC";
    }
    else {
        if(window.location.href.includes("filter")) {
            const url = window.location.href.split('?');
            window.location.href = url[0] + "?filter=name&sortOrder=DESC";
        }
        else window.location.href += "?filter=name&sortOrder=DESC";
    }
}
function sortByReleaseDateDESC(){
    if(window.location.href.includes("genre")) {
        const url = window.location.href.split('&');
        window.location.href = url[0] + "&filter=releaseDate&sortOrder=DESC";
    }
    else {
        if(window.location.href.includes("filter")) {
            const url = window.location.href.split('?');
            window.location.href = url[0] + "?filter=releaseDate&sortOrder=DESC";
        }
        else window.location.href += "?filter=releaseDate&sortOrder=DESC";
    }
}
function saveSelectedOption(){
    if(window.location.href.includes("name") && window.location.href.includes("ASC")) document.getElementById("sortoptions").value = "Nume cresc";
    else if(window.location.href.includes("name") && window.location.href.includes("DESC")) document.getElementById("sortoptions").value = "Nume desc";
    else if(window.location.href.includes("price") && window.location.href.includes("ASC")) document.getElementById("sortoptions").value = "Pret crescator";
    else if(window.location.href.includes("price") && window.location.href.includes("DESC")) document.getElementById("sortoptions").value = "Pret descrescator";
    else if(window.location.href.includes("releaseDate") && window.location.href.includes("ASC")) document.getElementById("sortoptions").value = "Data lansare cresc";
    else if(window.location.href.includes("releaseDate") && window.location.href.includes("DESC")) document.getElementById("sortoptions").value = "Data lansare desc";
    else if(window.location.href.includes("name") && window.location.href.includes("ASC")) document.getElementById("sortoptions").value = "Nume cresc";
    else document.getElementById("sortoptions").value = "Implicit";
}
window.onload = function() {
    saveSelectedOption();
};