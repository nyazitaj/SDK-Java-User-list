package edu.fbansept.dfsr_presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                "https://jsonplaceholder.typicode.com/users",
                response -> {

                    userList = new ArrayList<>();

                        for(int i = 0; i < response.length(); i++ ) {
                            try {
                                JSONObject json = response.getJSONObject(i);
                                User produit = new User(json);
                                userList.add(produit);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        RecyclerView rvUserList = findViewById(R.id.rvUserList);
                        rvUserList.setLayoutManager(new LinearLayoutManager(this));
                        rvUserList.setAdapter(new UserListAdapter(userList));

                },
                error -> Log.d("volley",error.toString())
        );

        RequestManager.getInstance(this).addToRequestQueue(jsonArrayRequest);



    }
}