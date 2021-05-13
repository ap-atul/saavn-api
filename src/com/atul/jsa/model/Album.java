package com.atul.jsa.model;

import java.util.List;

public class Album {
	public String name;
	public String artist;
	public String song_pids;
	public int songCount;
	public List<Music> songs;

	public Album() {
	}

	public Album(String name, String artist, String song_pids, int songCount, List<Music> songs) {
		super();
		this.name = Helper.ifNull(name);
		this.artist = Helper.ifNull(artist);
		this.song_pids = Helper.ifNull(song_pids);
		this.songCount = songCount;
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album [name=" + name + ", artist=" + artist + ", songCount=" + songCount + ", songs=" + songs + "]";
	}
}
