package com.simple.app.model;

public class SystemMessage {
    public enum Type {
        SUCCESS, WARNING, ERROR, BLANK
    }
    private String message;
    private Type type;

    public SystemMessage() {
        type = Type.BLANK;
        message = "";
    }

    public SystemMessage(Type type, String message) {
        this.type = type;
        this.message = message;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
