package org.tk2100.chat;

/**
 * Created by arcuri82 on 21-Mar-18.
 */
public class MessageDto {

    private  String author;

    private  String text;

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }
}
