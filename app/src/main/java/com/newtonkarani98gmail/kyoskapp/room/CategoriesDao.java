package com.newtonkarani98gmail.kyoskapp.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.newtonkarani98gmail.kyoskapp.models.Category;

import java.util.List;

@Dao
public interface CategoriesDao {

    @Insert
    public Long save(Category category);

    @Query("SELECT * FROM category")
    public List<Category> getAllCategory();

    @Query("DELETE FROM category")
    public void deleteAll();
}
