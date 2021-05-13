package com.atul.jsa.controller;

import java.util.List;

import com.atul.jsa.model.Album;
import com.atul.jsa.model.Music;

public interface JsaListener {
	void setSongs(List<Music> musics);

	void setAlbums(List<Album> albums);
}
