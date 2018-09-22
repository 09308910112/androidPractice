package com.lanyou.lpc.readassets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {


    private String filename = "test";
    private TextView btn_writen;
    private TextView btn_read;
    private TextView btn_show;
    private TextView et_input;
    private File myFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvContent = findViewById(R.id.tv_content);
        //initView();
       // initAssetRaw(tvContent);
      //  initInternalFile();
      //  initView();
      //  initExternalFile();
        initSp();
    }

    private void initSp() {
        Button btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivityForResult(new Intent(MainActivity.this,SPUtilActivity.class),110);
                startActivityForResult(new Intent(MainActivity.this,SqliteActivitiy.class),110);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 110 && data != null){
            Toast.makeText(this, data.getStringExtra("content"), Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        btn_writen = findViewById(R.id.btn_write);
        btn_read = findViewById(R.id.btn_read);
        btn_show = findViewById(R.id.btn_show);
        et_input = findViewById(R.id.et_input);
    }

    private void initExternalFile() {
        final File sdCard = Environment.getExternalStorageDirectory();
        myFile = new File(sdCard,"hellFile.txt");
        btn_writen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if(!sdCard.exists()){
                        Toast.makeText(MainActivity.this, "不存在sd卡", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this, "sd 写入成功", Toast.LENGTH_LONG).show();
                        myFile.createNewFile();
                        FileOutputStream fos = new FileOutputStream(myFile);
                        OutputStreamWriter osw = new OutputStreamWriter(fos);
                        osw.write(et_input.getText().toString());
                        osw.flush();
                        fos.flush();
                        osw.close();
                        fos.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = new FileInputStream(myFile);
                    InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
                    char[] buf = new char[fis.available()];
                    isr.read(buf);
                    isr.close();
                    fis.close();
                    String content = new String(buf);
                    btn_show.setText(content);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initInternalFile() {
        btn_writen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);//写入到内容存储
                    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                    osw.write(et_input.getText().toString());
                    osw.flush();
                    fos.flush();
                    osw.close();
                    fos.close();
                    Toast.makeText(MainActivity.this, "写入完成", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput(filename);
                    InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                    char[] buf = new char[fis.available()];
                    isr.read(buf);
                    String content = new String(buf);
                    btn_show.setText(content);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initAssetRaw(final TextView tvContent) {
        TextView tvRead = findViewById(R.id.tv_read);
        tvRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    readFileFromAssets(tvContent);
                    readFromRaw(tvContent);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void readFromRaw(TextView tvContent) throws IOException {
        InputStream inputStream = getResources().openRawResource(R.raw.myfile);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String inString;
        StringBuilder sb = new StringBuilder();
        while ((inString = br.readLine()) != null) {
            sb.append(inString);
        }
        tvContent.setText(sb.toString());
    }

    /**
     * 从Assets读取文件内容
     *
     * @param tvContent
     * @throws IOException
     */
    public void readFileFromAssets(TextView tvContent) throws IOException {
        InputStream is = getResources().getAssets().open("info.txt");
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader bfr = new BufferedReader(isr);
        String content;
        StringBuilder sb = new StringBuilder();
        while ((content = bfr.readLine()) != null) {
            sb.append(content);
        }
        tvContent.setText(sb.toString());
    }
}
