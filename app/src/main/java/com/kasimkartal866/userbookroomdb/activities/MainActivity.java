package com.kasimkartal866.userbookroomdb.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.kasimkartal866.userbookroomdb.R;
import com.kasimkartal866.userbookroomdb.adapter.UserAdapter;
import com.kasimkartal866.userbookroomdb.dao.RoomExecutor;
import com.kasimkartal866.userbookroomdb.databinding.ActivityMainBinding;
import com.kasimkartal866.userbookroomdb.models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    UserAdapter userAdapter;
    ArrayList<User> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        userAdapter = new UserAdapter();
        binding.recyclerView.setAdapter(userAdapter);
    }

    @Override
    protected void onResume() {
        RoomExecutor executor = new RoomExecutor(this);
        List<User> users = executor.getUsers();
        userAdapter.submitList(users);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.user_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_user) {
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}