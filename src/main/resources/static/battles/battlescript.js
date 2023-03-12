function select(image) {

    const elements = document.getElementsByClassName("movie-image");

    for (const element of elements) {
        element.classList.remove("movie-selected");
    }

    image.classList.add("movie-selected");

    document.getElementById("movie-selected").value = image.id;
}
