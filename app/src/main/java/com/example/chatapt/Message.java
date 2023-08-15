package com.example.chatapt;

public class Message {
                public  static  String sent_by_me="me";
                public static String sent_by_bot="bot";

                String sentBy;
                String message;

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public Message(String message, String sentBy) {
        this.sentBy = sentBy;
        this.message = message;
    }
}
