package com.example.rakesh.task;

/**
 * Created by Rakesh on 08-07-2017.
 */

public class Video {                         //data to be loaded inside recycler view
    private String name,description;
    private int imageId;
    static Video[] videos= {
            new Video("Wonder Woman", "2017 ‧ Fantasy/Science fiction film ‧ 2h 21m", R.drawable.wonder),
            new Video("Spider-Man: Homecoming", "2017 ‧ Fantasy/Science fiction film ‧ 2h 13m", R.drawable.spider),
            new Video("DON'T LET ME DOWN", "Singers: Chainsmokers, Daya", R.drawable.dont_let_me_down),
            new Video("NOT AFRAID", "Singer: Eminem", R.drawable.not_afraid)
    };
    private Video(String name,String description,int image){
        this.name=name;
        this.description=description;
        this.imageId=image;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    int getImageId(){
        return imageId;
    }
    }


