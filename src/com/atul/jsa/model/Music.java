package com.atul.jsa.model;

public class Music {
	public String id;
	public String album;
	public String albumArt;
	public String title;
	public String url;
	public String artist;

	public Music(String id, String album, String albumArt, String title, String url, String artist) {
		super();
		this.id = Helper.ifNull(id);
		this.album = Helper.ifNull(album);
		this.albumArt = Helper.ifNull(albumArt);
		this.title = Helper.ifNull(title);
		this.url = Helper.ifNull(url);
		this.artist = Helper.ifNull(artist);
	}

	public Music() {
	}

	@Override
	public String toString() {
		return "Music [id=" + id + ", album=" + album + ", albumArt=" + albumArt + ", title=" + title + ", url=" + url
				+ ", artist=" + artist + "]";
	}
}
