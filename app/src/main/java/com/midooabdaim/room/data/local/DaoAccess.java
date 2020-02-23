package com.midooabdaim.room.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    void addToItem(item... nItems);

//    @Insert
//    void addToMidoo(midoo... nMidoos);

    @Update
    void updateCoulamINTableName(item... nItems);
//
//    @Update
//    void updateCoulamINMidoo(midoo... nMidoos);

    @Delete
    void deleteFromTableName(item... nItems);

    @Query("SELECT * FROM item")
    List<item> getAllFromItem();

    //    @Query("select * from midoo where itemId=:ids")
//    List<midoo> getAllFromMidoo(int ids);


}
