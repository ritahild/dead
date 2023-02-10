package com.example.m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
   private Button xyeta;
   RecyclerView recyclerView;
    ArrayList< String > name = new ArrayList<>();
    ArrayList< String > photo = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        xyeta = (Button) findViewById(R.id.izbtn);


        xyeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VarIntent = new Intent(HomeActivity.this, VarActivity.class);
                startActivity(VarIntent);
            }
        });


        try {


            JSONObject jsonObject = new JSONObject(JsonDataFromAsset("tovar.json"));
            JSONArray jsonArray = jsonObject.getJSONArray("tovar");
            for(int i=0;i< jsonArray.length();i++){
                JSONObject userData=jsonArray.getJSONObject(i);

                name.add(userData.getString("name"));
                photo.add(userData.getString("photo"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }


        Helperadapter helperAdapter = new Helperadapter(name,photo,HomeActivity.this);
        recyclerView.setAdapter(helperAdapter);
    }
    private String JsonDataFromAsset(String fileName){
        String json = null;
        try{
            InputStream inputStream = getAssets().open(fileName);

            int sizeOfFile = inputStream.available();

            byte[] bufferData = new byte[sizeOfFile];

            inputStream.read(bufferData);

            inputStream.close();
            json = new String(bufferData, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
            return null;

        }
        return json;




    }
}