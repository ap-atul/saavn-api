package com.atul.jsa.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.jsoup.Jsoup;

import com.atul.jsa.model.Album;
import com.atul.jsa.model.Music;

class JsaLoader {

	public static List<Music> getSongsByQuery(String query) {
		String url = JsaApiBuilder.getSongsSearch(query);
		List<Music> musicList = new ArrayList<>();
		try {

			String resp = (Jsoup.connect(url).userAgent(JsaConstants.USER_AGENT).execute().body());
			musicList.addAll(JsaParser.toMusic(new JSONObject(resp.trim())));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return musicList;
	}

	public static List<Album> getAlbumsByQuery(String query) {
		String url = JsaApiBuilder.getSongsSearch(query);
		List<Album> albumList = new ArrayList<>();
		try {

			String resp = (Jsoup.connect(url).userAgent(JsaConstants.USER_AGENT).execute().body());
			List<Album> parsedList = JsaParser.toAlbum(new JSONObject(resp.trim()));

			for (Album album : parsedList) {
				if (album.song_pids.equals(""))
					continue;

				String nres = Jsoup.connect(JsaApiBuilder.getSongsAlbum(album.song_pids)).userAgent(JsaConstants.USER_AGENT).execute().body();
				album.songs.addAll(JsaParser.toAlbumMusic(new JSONObject(nres.trim()), album.song_pids.split(",")));
				albumList.add(album);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return albumList;
	}
}
