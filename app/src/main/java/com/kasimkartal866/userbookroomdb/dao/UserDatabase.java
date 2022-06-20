package com.kasimkartal866.userbookroomdb.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kasimkartal866.userbookroomdb.models.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static volatile UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null)
            instance = createInstance(context);
        return instance;
    }

    private static synchronized UserDatabase createInstance(Context context) {
        return Room.databaseBuilder(context, UserDatabase.class, "UserDB.db").build();
    }

    public abstract UserDao getDao();
}
