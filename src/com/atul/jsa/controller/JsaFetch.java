package com.atul.jsa.controller;

public class JsaFetch {
	private final JsaListener listener;

	public JsaFetch(JsaListener listener) {
		this.listener = listener;
	}

	public void songs(String query) {
		listener.setSongs(JsaLoader.getSongsByQuery(query));
	}

	public void albums(String query) {
		listener.setAlbums(JsaLoader.getAlbumsByQuery(query));
	}
}
