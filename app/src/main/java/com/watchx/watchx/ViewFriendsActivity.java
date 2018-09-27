package com.watchx.watchx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.watchx.watchx.models.Friend;
import com.watchx.watchx.services.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewFriendsActivity extends AppCompatActivity {
    List<Friend> friendList = new ArrayList<>();
    private RecyclerView friendsRecyclerView;
    private RecyclerView.Adapter friendsAdapter;
    private RecyclerView.LayoutManager friendsLayoutManager;
    private static String[] friends = {"+254714938685", "+254718467087"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_friends);
        friendsRecyclerView = (RecyclerView) findViewById(R.id.friends_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        friendsRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        friendsLayoutManager = new LinearLayoutManager(this);
        friendsRecyclerView.setLayoutManager(friendsLayoutManager);

        // specify an adapter (see also next example)
        friendsAdapter = new MyAdapter(friends);
        friendsRecyclerView.setAdapter(friendsAdapter);

    }

    public void addFriend(View view) {
        EditText nameText = (EditText) findViewById(R.id.enterName);
        EditText numberText = (EditText) findViewById(R.id.enterNumber);
        // Set the destination phone number to the string in editText.
        String friendName = nameText.getText().toString();
        String friendNumber = numberText.getText().toString();

        Friend newFriend = new Friend(friendName, friendNumber);
        friendList.add(newFriend);

    }

}
