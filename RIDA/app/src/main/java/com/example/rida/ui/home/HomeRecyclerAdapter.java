package com.example.rida.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rida.Post;
import com.example.rida.PostDetailActivity;
import com.example.rida.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<Post> newsfeed;
    public HomeRecyclerAdapter(ArrayList<Post> n)
    {
        newsfeed = n;
    }

    private String[] names = {
            "Person 1",
            "Person 2",
            "Person 3",
            "Person 4",
            "Person 5",
            "Person 6",
            "Person 7",
            "Person 8",
            "Person 9",
            "Person 10",
    };
    private String[] contents = {
            "content 1",
            "content 2",
            "content 3",
            "content 4",
            "content 5",
            "content 6",
            "content 7",
            "content 8",
            "content 9",
            "content 10",
    };

    //private DatabaseReference mDatabase;
    //private String[] names;
    //private String[] contents;

    /*private void writeNewPost() {
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }*/

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView postName;
        public TextView postContent;
        public TextView postTime;

        public ViewHolder(View post) {
            super(post);
            postName = (TextView) post.findViewById(R.id.post_name);
            postContent = (TextView) post.findViewById(R.id.post_content);
            postTime = (TextView) post.findViewById(R.id.post_time);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       /*
        ---This block of code was for debugging. Might want to put a display the newsfeed list here---
       FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;
        myRef = database.getReference("newsfeed");
        Post p = new Post("charlie", "hey friends", "yesterday");
        myRef.push().setValue(p);*/

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.content_posts, viewGroup, false);



        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //it appears that this is where we need to implement the data of the posts
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //myRef = database.getReference("newsfeed");
        //DataSnapshot ds = database.onDataChange();
        viewHolder.postName.setText(newsfeed.get(i).getAuthor());
        viewHolder.postContent.setText(newsfeed.get(i).getContents());
        viewHolder.postTime.setText(newsfeed.get(i).getTimestamp());
    }

    @Override
    public int getItemCount() {
        return newsfeed.size();
    }

}
