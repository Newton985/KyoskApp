package com.newtonkarani98gmail.kyoskapp.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.newtonkarani98gmail.kyoskapp.models.Item;

import java.util.List;

@Dao
public interface ItemsDao {

    @Insert
    public Long save(Item item);

    @Query("SELECT * FROM item")
    public List<Item> getAllItems();

    @Query("SELECT * FROM Item LIMIT 5")
    public List<Item> getCartItems();

    @Query("DELETE FROM item")
    public void deleteAll();
}
