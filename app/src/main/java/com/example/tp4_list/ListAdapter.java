package com.example.tp4_list;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
   Activity context;
   List<String> marks;

   public ListAdapter(Activity context,List<String> lst){
       super(context,R.layout.element,lst);
       this.context = context;
       this.marks = lst;
   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View cell = inflater.inflate(R.layout.element,null);

        ImageView img = cell.findViewById(R.id.img);
        TextView txt = cell.findViewById(R.id.mark);

        Double mark = Double.parseDouble(marks.get(position));
        if (mark >=10){
            img.setImageResource(R.drawable.happy);
        }else{
            img.setImageResource(R.drawable.sad);

        }

        txt.setText(marks.get(position));



        return cell;

    }
}
