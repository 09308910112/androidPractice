package com.lanyou.lpc.test;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //initData();
        initData1();
        initData2();
    }

    @SuppressLint("MissingPermission")
    private void initData2() {

        String[] c = new String[]{
                CalendarContract.Reminders.EVENT_ID,
                CalendarContract.Reminders.MINUTES,
                CalendarContract.Reminders.METHOD,

        };
        Uri contentUri = CalendarContract.Reminders.CONTENT_URI;
        Cursor cur = null;
        ContentResolver cr = getContentResolver();

        cur = cr.query(contentUri,
                c,
                null,
                null,
                null);

        while (cur.moveToNext()) {
            // Get the field values
            String f = cur.getString(0);
            String s = cur.getString(1);
            String t = cur.getString(2);

            Log.i(DEBUG_TAG,
                    "f: " + f +
                            ",s:  " + s +
                            ",t: " + t);

        }

    }

    public static final String[] INSTANCE_PROJECTION = new String[]{
            CalendarContract.Instances.EVENT_ID,      // 0
            CalendarContract.Instances.BEGIN,         // 1
            CalendarContract.Instances.TITLE,          // 2
            CalendarContract.Instances.BEGIN,
            CalendarContract.Instances.END,
            CalendarContract.Instances.MAX_REMINDERS,

    };


    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    // The indices for the projection array above.
    private static final int PROJECTION_ID_INDEX = 0;
    private static final int PROJECTION_BEGIN_INDEX = 1;
    private static final int PROJECTION_TITLE_INDEX = 2;
    private static final String DEBUG_TAG = "lpc888";

    private void initData1() {

        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2011, 9, 23, 8, 0);
        long startMillis = beginTime.getTimeInMillis();
        Calendar endTime = Calendar.getInstance();
        endTime.set(2022, 10, 24, 8, 0);
        long endMillis = endTime.getTimeInMillis();

        Cursor cur = null;
        ContentResolver cr = getContentResolver();
        Uri.Builder builder = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(builder, startMillis);
        ContentUris.appendId(builder, endMillis);

        cur = cr.query(builder.build(),
                INSTANCE_PROJECTION,
                null,
                null,
                null);

        while (cur.moveToNext()) {
            String title = null;
            long eventID = 0;
            long beginVal = 0;
            String begin = null;
            String end = null;
            String maxReminders = null;

            // Get the field values
            eventID = cur.getLong(PROJECTION_ID_INDEX);
            beginVal = cur.getLong(PROJECTION_BEGIN_INDEX);
            title = cur.getString(PROJECTION_TITLE_INDEX);
            begin = cur.getString(3);
            end = cur.getString(4);
            //最多支持5个提醒
            maxReminders = cur.getString(5);


            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(beginVal);
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Log.i(DEBUG_TAG,
                    "EventId: " + eventID +
                            ",Event:  " + title +
                            ",Date: " + formatter.format(calendar.getTime()) +
                            ",Begin:  " + stampToDate(begin) +
                            ",end:  " + stampToDate(end) +
                            ",maxReminders: " + maxReminders
            );
        }
    }

    private static String calanderURL = "content://com.android.calendar/calendars";
    private static String calanderEventURL = "content://com.android.calendar/events";
    private static String calanderRemiderURL = "content://com.android.calendar/reminders";

    private void initData() {
        Cursor eventCursor = getContentResolver().query(Uri.parse(calanderEventURL), null, null, null, null);

        if (eventCursor == null) {
            Toast.makeText(this, "eventCursor is null", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (eventCursor.moveToNext()) {
            String eventTitle = eventCursor.getString(eventCursor.getColumnIndex("title"));
            sb.append(eventTitle).append("\n");
            Log.e("lpc888", "内容：" + eventTitle);
        }
        TextView tvContent = findViewById(R.id.tv_content);
        tvContent.setText(sb.toString());
    }
}
