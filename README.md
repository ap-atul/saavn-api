# saavn-api
Ready to integrate saavn api for musc downloading and listeniing

## Usage
1. Declare the fetch oject, attach the JsaListener
```java

class Sample implements JsaListener {

  // this refers to the instance of the JsaListener
  JsaFetch fetch = new JsaFetch(this);
  
}
```

2. Call methods to fetch data based on query
``` java

String myQuery = "something good";

// for songs
fetch.songs(myQuery);

//for albums
fetch.albums(myQuery);
```

3. Implements the methods of the JsaListener
```java
@Override
public void setSongs(List<Music> musics) {
  // data from fetch
}

@Override
public void setAlbums(List<Album> albums) {
  // data from fetch
}

```

4. Music and Album Objects
```java
// both objects have properties as public so not getters or setters
```
