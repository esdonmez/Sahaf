package com.sahafapp.seray.sahaf.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sahafapp.seray.sahaf.Helpers.SampleBitmapSize;
import com.sahafapp.seray.sahaf.Models.AdvertModel;
import com.sahafapp.seray.sahaf.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

public class AdvertAdapter extends BaseAdapter
{
    private Context mContext;
    private List<AdvertModel> advertList;
    ImageView bookImage;
    TextView bookName, city, price;
    LinearLayout item;
    RelativeLayout right;


    public AdvertAdapter(Context c, List<AdvertModel> advertsList)
    {
        mContext = c;
        this.advertList = advertsList;
    }


    @Override
    public int getCount()
    {
        return advertList.size();
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
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v;

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_advert, parent, false);
        }

        else
        {
            v = (View) convertView;
        }

        item = (LinearLayout) v.findViewById(R.id.item);
        bookImage = (ImageView) v.findViewById(R.id.bookImage);
        bookName = (TextView) v.findViewById(R.id.bookName);
        city = (TextView) v.findViewById(R.id.city);
        price = (TextView) v.findViewById(R.id.price);
        right = (RelativeLayout) v.findViewById(R.id.right);

        if(position % 2 == 0)
        {
            item.setBackgroundColor(Color.parseColor("#fbfbfb"));
        }
        else
        {
            item.setBackgroundColor(Color.parseColor("#ffffff"));
            right.setBackgroundColor(Color.parseColor("#ffffff"));
        }


       /* int imageResource = mContext.getResources().getIdentifier(advertList.get(position).Image, null, mContext.getPackageName());
        Bitmap bitmap = SampleBitmapSize.decodeSampledBitmapFromResource(mContext.getResources(), imageResource, 100, 100);*/

        Picasso.with(mContext).load(advertList.get(position).Image).into(bookImage);
        bookName.setText(advertList.get(position).Name);
        city.setText(advertList.get(position).Distance);
        price.setText(advertList.get(position).Price);

        return v;
    }
}
