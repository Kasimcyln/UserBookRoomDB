package com.kasimkartal866.userbookroomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.kasimkartal866.userbookroomdb.models.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Insert
    void addUser(User user);

    @Delete
    void deleteUser(User user);
}
