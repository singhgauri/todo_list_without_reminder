package com.example.todolist;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import java.util.List;

public class ItemRepository {

    private ItemDao itemDao;
    private LiveData<List<Item>> allItems;

    public ItemRepository(Application application) {

        ItemDatabase database = ItemDatabase.getInstance(application);
        itemDao = database.itemDao();
        allItems = itemDao.getAllNotes();
    }

    public  void insert(Item item) {

        new InsertItemAsyncTask(itemDao).execute(item);

    }
    public void update(Item item){

        new UpdateItemAsyncTask(itemDao).execute(item);

    }
    public void delete(Item item) {

        new DeleteItemAsyncTask(itemDao).execute(item);

    }
    public void deleteAllItems(){

        new DeleteAllItemsAsyncTask(itemDao).execute();

    }
    public LiveData<List<Item>> getAllNotes(){
        return allItems;
    }


    private static class InsertItemAsyncTask extends AsyncTask<Item,Void ,Void> {
        private ItemDao itemDao;

        public InsertItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.insert(items[0]);
            return null;
        }
    }

    private static class UpdateItemAsyncTask extends AsyncTask<Item,Void ,Void> {
        private ItemDao itemDao;

        public UpdateItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }


        @Override
        protected Void doInBackground(Item... items) {
            itemDao.update(items[0]);
            return null;
        }
    }

    private static class DeleteItemAsyncTask extends AsyncTask<Item,Void ,Void> {
        private ItemDao itemDao;

        public DeleteItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }


        @Override
        protected Void doInBackground(Item... items) {
            itemDao.delete(items[0]);
            return null;
        }
    }

    private static class DeleteAllItemsAsyncTask extends AsyncTask<Void,Void ,Void> {
        private ItemDao itemDao;

        public DeleteAllItemsAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.deleteAllItems();
            return null;
        }
    }




}



