package com.example.cpy.ffmpegdemo2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("MyFFmpeg");
    }

    private TextView mInfoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfoView = findViewById(R.id.sample_text);

    }

    public void format(View view) {
        String filePath = Environment.getExternalStorageDirectory() + "/Test/test.mp4";
        String dirPath = Environment.getExternalStorageDirectory() + "/Test";
        Log.d("cpy", "filePath = " + filePath + " exist?? = " + new File(filePath).exists());
        int result = save5HeadPic2Disk(filePath, dirPath);
        mInfoView.setText(result);
//        mInfoView.setText(avformatInfo());
    }

    public void codec(View view) {
        mInfoView.setText(avcodecInfo());
    }

    public void filter(View view) {
        mInfoView.setText(avfilterInfo());
    }

    public void config(View view) {
        mInfoView.setText(configurationInfo());
    }

    public native String avformatInfo();
    public native String avcodecInfo();
    public native String avfilterInfo();
    public native String configurationInfo();
    /**
     * 保存钱
     * @param videoPath
     * @return
     */
    public native int save5HeadPic2Disk(String videoPath, String dirPath);
}
