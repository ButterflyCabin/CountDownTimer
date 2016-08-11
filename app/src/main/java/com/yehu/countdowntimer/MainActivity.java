package com.yehu.countdowntimer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView mListView;
    MyCountDownTimer mMyCountDownTimer;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mListView = (ListView) findViewById( R.id.listView );
        MyAdapter adapter = new MyAdapter( this );
        mListView.setAdapter( adapter );

        mMyCountDownTimer = new MyCountDownTimer( 1000, 1000, adapter );
    }

    @Override
    protected void onResume() {

        super.onResume();
        mMyCountDownTimer.start();
    }

    @Override
    protected void onPause() {

        super.onPause();
        mMyCountDownTimer.cancel();
    }
}
