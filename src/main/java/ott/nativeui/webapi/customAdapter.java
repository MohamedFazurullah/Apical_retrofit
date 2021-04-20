package ott.nativeui.webapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder> {

    private ArrayList<Hero> arrayList;


    public customAdapter(ArrayList<Hero> arrayList) {

        this.arrayList = arrayList;


    }

    @NonNull
    @Override
    public customAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txt_card.setText(this.arrayList.get(position).getName());

        holder.cardImg.setImageURI(Uri.parse("https://www.simplifiedcoding.net/demos/marvel/ironman.jpg"));




    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_card;
        private ImageView cardImg;

        public ViewHolder(View view) {
            super(view);
            txt_card = (TextView) view.findViewById(R.id.text);
            cardImg = (ImageView) view.findViewById(R.id.img);

        }
    }
}
