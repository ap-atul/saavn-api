package com.atul.jsa.controller;

class JsaApiBuilder {

	private static StringBuilder builder;

	public static String getSongsSearch(String query) {
		query = query.replace(" ", "%20");

		builder = new StringBuilder();
		builder.append(JsaConstants.API_SONG_SEARCH);
		builder.append(query);

		return builder.toString();
	}

	public static String getSongsAlbum(String query) {
		builder = new StringBuilder();
		builder.append(JsaConstants.API_SONGS_FROM_ALBUM);
		builder.append(query);

		return builder.toString();
	}
}
