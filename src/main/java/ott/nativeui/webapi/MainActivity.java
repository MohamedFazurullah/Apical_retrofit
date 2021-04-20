package ott.nativeui.webapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Hero> arrayList;
    customAdapter customAdapter;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //calling the method to display the heroes
        getHeroes();
    }

    private void getHeroes() {
        Call<ArrayList<Hero>> call = RetrofitClient.getInstance().getMyApi().getHeroes();
        call.enqueue(new Callback<ArrayList<Hero>>() {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {


                arrayList = response.body();

                for(int i = 0;i<arrayList.size();i++){
                    Log.d(TAG, "onResponse: "+arrayList.get(i).getImageurl());

                }

                 customAdapter = new customAdapter(arrayList);
                recyclerView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable t) {

            }


        });
    }
}
