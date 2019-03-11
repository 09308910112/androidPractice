package com.example.utillibrary;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class SDCardUtil {

    private final static String PATH = Environment.getExternalStorageDirectory() + "/00sdcard/00record331";
    private final static String FILENAME = "/notes.txt";

    /**
     * 　　 * 写文件
     */
    public static void onWrite(String text) {
        text = text + "\n";
        try {
            //1.判断是否存在sdcard
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                //目录
                File path = new File(PATH);
                //文件
                File f = new File(PATH + FILENAME);
                if (!path.exists()) {
                    //2.创建目录，可以在应用启动的时候创建
                    path.mkdirs();
                }
                if (!f.exists()) {
                    //3.创建文件
                    f.createNewFile();
                }
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f, true));
                osw.write(text);
                osw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
