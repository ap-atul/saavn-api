package com.atul.jsa.controller;

import java.util.List;

import com.atul.jsa.model.Album;
import com.atul.jsa.model.Music;

public class JsaFetch {
	private final JsaListener listener;

	public JsaFetch(JsaListener listener) {
		this.listener = listener;
	}

	public void songs(final String query) {
		new Thread() {
			@Override
			public void run() {
				List<Music> music = JsaLoader.getSongsByQuery(query);
				listener.setSongs(music);
			}
		}.start();
	}

	public void albums(final String query) {
		new Thread() {
			@Override
			public void run() {
				List<Album> album = JsaLoader.getAlbumsByQuery(query);
				listener.setAlbums(album);
			}
		}.start();
	}
}
