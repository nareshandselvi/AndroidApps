package com.example.windows_home.nature;

/**
 * Created by windows-home on 04-05-2015.
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;
import com.example.windows_home.nature.RowItem;


class MyBaseAdapter extends BaseAdapter  {

    List<RowItem> rowItems;
    Context context;

    public MyBaseAdapter(Context c,List<RowItem> items) {
        this.context=c;
        this.rowItems = items;
        //Title = text;
        //Detail = text1;
        //imge = text3;

    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }
    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }





    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Activity.LAYOUT_INFLATER_SERVICE);
        //LayoutInflater inflater = getLayoutInflater();

            convertView = inflater.inflate(R.layout.treat_list_item, parent, false);
            txtTitle = (TextView) convertView.findViewById(R.id.title);
            imageView = (ImageView) convertView.findViewById(R.id.icon);

        RowItem rowItem = (RowItem) getItem(position);


        txtTitle.setText(rowItem.getTitle());
        imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }

}