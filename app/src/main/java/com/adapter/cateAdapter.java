package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ocean.R;
import com.model.Categories;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class cateAdapter extends BaseAdapter {
    ArrayList<Categories> arrayListCate;
    Context context;

    public cateAdapter(ArrayList<Categories> arrayListCate, Context context) {
        this.arrayListCate = arrayListCate;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListCate.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListCate.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class Viewholder{
        TextView txttenloai;
        ImageView picture;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder viewholder = null;
        if (view == null){
            viewholder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_cate,null);
            viewholder.txttenloai = (TextView) view.findViewById(R.id.textViewCate);
            viewholder.picture = (ImageView) view.findViewById(R.id.pictureCate);
            view.setTag(viewholder);
        }
        else {
            viewholder = (Viewholder) view.getTag();
            Categories categories = (Categories) getItem(i);
            viewholder.txttenloai.setText(categories.getName());
            Picasso.with(context).load(categories.getPicture())
                    .placeholder(R.drawable.errorimagegeneric)
                    .error(R.drawable.errorimagegeneric)
                    .into(viewholder.picture);
        }
        return view;
    }
}
