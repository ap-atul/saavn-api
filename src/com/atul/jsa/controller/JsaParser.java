package com.atul.jsa.controller;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.atul.jsa.model.Album;
import com.atul.jsa.model.Music;

class JsaParser {

	public static List<Music> toMusic(JSONObject json) {
		List<Music> musicList = new ArrayList<>();

		if (!json.has("songs") && !json.has("data"))
			return musicList;

		JSONObject songs = json.getJSONObject("songs");
		JSONArray data = songs.getJSONArray("data");

		for (int i = 0; i < data.length(); i++) {
			JSONObject obj = data.getJSONObject(i);
			Music m = getMusic(obj);

			if (m != null)
				musicList.add(m);
		}

		return musicList;
	}

	private static Music getMusic(JSONObject obj) {
		String id = null, album = null, title = null, albumArt = null, url = null, artist = null;

		if (obj.has("id"))
			id = obj.getString("id");

		if (obj.has("album"))
			album = obj.getString("album");

		if (obj.has("description"))
			title = obj.getString("description");

		if (obj.has("image"))
			albumArt = obj.getString("image");

		if (obj.has("more_info")) {
			JSONObject sub = obj.getJSONObject("more_info");

			if (sub.has("primary_artists"))
				artist = sub.getString("primary_artists");

			if (sub.has("vlink"))
				url = sub.getString("vlink");

		}

		return new Music(id, album, albumArt, title, url, artist);
	}

	public static List<Album> toAlbum(JSONObject json) {
		List<Album> albumList = new ArrayList<>();

		if (!json.has("albums") && !json.has("data"))
			return albumList;

		JSONObject songs = json.getJSONObject("albums");
		JSONArray data = songs.getJSONArray("data");

		for (int i = 0; i < data.length(); i++) {
			JSONObject obj = data.getJSONObject(i);
			Album a = getAlbum(obj);

			if (a != null)
				albumList.add(a);
		}

		return albumList;
	}

	private static Album getAlbum(JSONObject obj) {
		String name = null, artist = null, song_pids = null;
		int songCount = 0;
		List<Music> songs = new ArrayList<>();

		if (obj.has("title"))
			name = obj.getString("title");

		if (obj.has("music"))
			artist = obj.getString("music");

		if (obj.has("more_info")) {
			JSONObject more = obj.getJSONObject("more_info");

			if (more.has("song_pids")) {
				song_pids = more.getString("song_pids").replace(" ", "");
				songCount = song_pids.split(",").length;
			}
		}

		return new Album(name, artist, song_pids, songCount, songs);
	}

	public static List<Music> toAlbumMusic(JSONObject json, String[] pids) {
		List<Music> music = new ArrayList<>();

		for (String pid : pids) {
			if (json.has(pid)) {
				JSONObject obj = json.getJSONObject(pid);
				String id = null, album = null, title = null, albumArt = null, url = null, artist = null;

				if (obj.has("id"))
					id = obj.getString("id");

				if (obj.has("album"))
					album = obj.getString("album");

				if (obj.has("song"))
					title = obj.getString("song");

				if (obj.has("image"))
					albumArt = obj.getString("image");

				if (obj.has("primary_artists"))
					artist = obj.getString("primary_artists");

				if (obj.has("vlink"))
					url = obj.getString("vlink");

				music.add(new Music(id, album, albumArt, title, url, artist));
			}
		}

		return music;
	}
}
