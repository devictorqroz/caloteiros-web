function alterFontClass() {
	$("font").attr("class", "linksVermelhos");
}

$("button").on("click", function(event) {
	alterFontClass();
});