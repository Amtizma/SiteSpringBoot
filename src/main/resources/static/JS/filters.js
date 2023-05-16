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