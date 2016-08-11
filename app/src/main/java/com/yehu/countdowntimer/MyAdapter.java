package com.yehu.countdowntimer;

/**
 * desc：
 * Created by yehu on 2016/7/27.
 */
import java.text.DateFormat;
import java.util.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    private static final int COUNT = 30;

    private Context context;
    private DateFormat dateFormat;

    public MyAdapter(Context context) {

        this.context = context;
        dateFormat = DateFormat.getTimeInstance();
    }

    @Override
    public int getCount() {

        return COUNT;
    }

    @Override
    public String getItem( int position ) {

        return "Item " + String.valueOf( position );
    }

    @Override
    public long getItemId( int position ) {

        return position;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {

        if ( convertView == null ) {
            convertView = LayoutInflater.from( getContext() ).inflate( android.R.layout.two_line_list_item, parent, false );
        }

        TextView text1 = (TextView) convertView.findViewById( android.R.id.text1 );
        TextView text2 = (TextView) convertView.findViewById( android.R.id.text2 );

        text1.setText( getItem( position ) );
        text2.setText( getTimeString( position ) );

        return convertView;
    }

    private CharSequence getTimeString( int position ) {

        if ( position % 2 == 0 ) {
            long between = (1469893920000L-System.currentTimeMillis()-(position*1000)) / 1000;//除以1000是为了转换成秒
            long day = between / (24 * 3600);
            long hour = between % (24 * 3600) / 3600;
            long minute = between % 3600 / 60;
            long second = between % 60 / 60;

            return day+" 天 "+hour+" 时 "+minute+" 分 "+second+" 秒 ";//dateFormat.format( Calendar.getInstance().getTime() );
        }
        else {
            return null;
        }
    }

    private Context getContext() {

        return context;
    }
}