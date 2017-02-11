package com.example.windows_home.imagegallery;

/**
 *
 * In listview adapter class, string arrays are passed into the ListViewAdapter and
 * set into the TextViews and ImageViews  by the positions.
 */
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    ImageLoad imageLoader;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public ListViewAdapter(Context context,
                           ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        data = arraylist;
        imageLoader = new ImageLoad(context);
    }



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView title;
        ImageView url;
        CheckBox clickbox;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listview_item, parent, false);
        // Get the position
        resultp = data.get(position);
        title = (TextView) itemView.findViewById(R.id.title);
        url = (ImageView) itemView.findViewById(R.id.url);
        clickbox = (CheckBox) itemView.findViewById(R.id.checkBox1);

        clickbox.setOnClickListener( new View.OnClickListener(){
                                         public void onClick(View v){
                                             CheckBox cb = (CheckBox) v ;

                                         }
                                     }






        title.setText(resultp.get(MainActivity.TITLE));
        imageLoader.DisplayImage(resultp.get(MainActivity.URL), url);
        // Capture ListView item click
        return itemView;
    }
}