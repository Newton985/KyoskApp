package com.newtonkarani98gmail.kyoskapp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.newtonkarani98gmail.kyoskapp.models.Category;
import com.newtonkarani98gmail.kyoskapp.models.Item;

@Database(version = 1, entities = {Item.class, Category.class}, exportSchema = false)
public abstract class KyoskDatabase extends RoomDatabase {
  public abstract  ItemsDao getItemDao();
  public  abstract  CategoriesDao categoriesDao();
}
