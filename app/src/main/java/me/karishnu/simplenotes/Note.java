package me.karishnu.simplenotes;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Note extends RealmObject {
    @PrimaryKey
    private int id;
    private String text;

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}