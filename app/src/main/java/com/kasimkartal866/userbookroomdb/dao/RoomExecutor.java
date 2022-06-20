package com.kasimkartal866.userbookroomdb.dao;

import android.content.Context;
import android.os.AsyncTask;

import com.kasimkartal866.userbookroomdb.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class RoomExecutor {
    private final UserDao dao;

    public RoomExecutor(Context context) {
        dao = UserDatabase.getInstance(context).getDao();
    }

    public List<User> getUsers() {
        List<User> data = new ArrayList<>();
        GetUsers_Async getUsersAsync = new GetUsers_Async();
        try {
            data = getUsersAsync.execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void addUser(User user) {
        if (user != null) {
            try {
                new AddUsers_Async().execute(user).get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //**********************************************************************************************
    //**********************************************************************************************
    //**********************************************************************************************

    private class GetUsers_Async extends AsyncTask<Void, Void, List<User>> {
        @Override
        protected List<User> doInBackground(Void... voids) {
            return dao.getAll();
        }
    }

    private class AddUsers_Async extends AsyncTask<User, Void, Void> {
        @Override
        protected Void doInBackground(User... users) {
            dao.addUser(users[0]);
            return null;
        }
    }
}
