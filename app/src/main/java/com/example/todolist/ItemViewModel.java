package com.example.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private ItemRepository repository;
    private LiveData<List<Item>> allItems;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(application);
        allItems = repository.getAllNotes();
    }

    public void insert(Item item){
        repository.insert(item);
    }

    public void update(Item item){
        repository.update(item);
    }

    public void delete(Item item){
        repository.delete(item);
    }

    public void deleteAllItems(Item item){
        repository.deleteAllItems();
    }

    public LiveData<List<Item>> getAllItems() {
        return allItems;
    }

}
