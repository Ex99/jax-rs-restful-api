package com.example.schemas;

public class Todo {
    private Integer id;
    private String name;
    private String description;
    private boolean isDone;

    public Todo(String name) {
        this(name, null);
    }

    public Todo(String name, String description) {
        this(null, name, description);
    }

    public Todo(Integer id, String name, String description) {
        this(id, name, description, false);
    }

    public Todo(Integer id, String name, String description, boolean isDone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isDone = isDone;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
}
