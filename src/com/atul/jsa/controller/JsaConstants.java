package com.atul.jsa.controller;

/**
 * All apis to interact with using very small amount of info.
 * 
 * @author atul, ap-atul@github
 */
class JsaConstants {

	// song search api, requires a string query (string)
	public static final String API_SONG_SEARCH = "https://www.jiosaavn.com/api.php?__call=autocomplete.get&_format=json&_marker=0&cc=in&includeMetaTags=1&query=";

	// songs in album, requires comma separated ids (string)
	public static final String API_SONGS_FROM_ALBUM = "https://www.jiosaavn.com/api.php?__call=song.getDetails&cc=in&_marker=0%3F_marker%3D0&_format=json&pids=";
}
