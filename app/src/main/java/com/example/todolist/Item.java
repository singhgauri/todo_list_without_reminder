package com.example.todolist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName= "item_table")
public class Item {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String description;

    private int date;

    public Item(String name, String description, int date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDate() {
        return date;
    }
}
