    package com.lanyou.lpc.readassets;

    import android.content.ContentValues;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    import com.lanyou.lpc.readassets.DB.Db;

    public class SqliteActivitiy extends AppCompatActivity {

        private Button btn_query;
        private TextView tvShow;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sqlite_activitiy);
            initView();
            initListener();
            //  insertData();

        }

        private void insertData() {
            Db db = new Db(this);
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", "小刘");
            values.put("sex", "男");
            database.insert(Db.DB_TABLE, null, values);

            values = new ContentValues();
            values.put("name", "小红");
            values.put("sex", "女");
            database.insert(Db.DB_TABLE, null, values);
            database.close();
        }

        private void initListener() {
            btn_query.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Db db = new Db(SqliteActivitiy.this);
                    SQLiteDatabase database = db.getReadableDatabase();
                    Cursor cursor = database.query(Db.DB_TABLE, null, null, null, null, null, null);
                   StringBuilder sb = new StringBuilder();
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String sex = cursor.getString(cursor.getColumnIndex("sex"));
                        sb.append(name+","+sex);
                    }
                    cursor.close();
                    db.close();
                    tvShow.setText(sb.toString());
                }
            });
        }

        private void initView() {
            btn_query = findViewById(R.id.btn_query);
            tvShow = findViewById(R.id.tv_show);
        }

    }
