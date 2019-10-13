package com.example.top10downloader;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import javax.xml.transform.Templates;

public class FeedAdaptor extends ArrayAdapter {
    private static final String TAG = "FeedAdaptor";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;



    public FeedAdaptor(Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;

    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null) {
            Log.d(TAG, "getView: called with a null convertview");
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            Log.d(TAG, "getView: provided a convertview");
            viewHolder=(ViewHolder)convertView.getTag();
        }
        //TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        //TextView tvArtist = (TextView) convertView.findViewById(R.id.tvArtist);
        //TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSummary);

        FeedEntry currentApp = applications.get(position);
        viewHolder.tvName.setText(currentApp.getName());
        viewHolder.tvArtist.setText(currentApp.getArtist());
        viewHolder.tvSummary.setText(currentApp.getSummary());

        return convertView;
    }
    private class ViewHolder
    {
        final TextView tvName;
        final TextView tvArtist;
        final TextView tvSummary;

        ViewHolder(View v) {
            this.tvName = v.findViewById(R.id.tvName);
            this.tvArtist = v.findViewById(R.id.tvArtist);
            this.tvSummary = v.findViewById(R.id.tvSummary);
        }
    }

}
