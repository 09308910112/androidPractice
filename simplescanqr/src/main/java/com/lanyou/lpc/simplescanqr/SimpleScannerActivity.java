package com.lanyou.lpc.simplescanqr;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SimpleScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
          // Programmatically initialize the scanner view
        setContentView(R.layout.activity_scanner);                // Set the scanner view as the content view
        mScannerView = new ZXingScannerView(this);
        FrameLayout fl_container = findViewById(R.id.fl_container);
        fl_container.addView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
        mScannerView.setAutoFocus(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
       // Log.v(TAG, rawResult.getText()); // Prints scan results
       // Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        Toast.makeText(this, rawResult.getText().toString(), Toast.LENGTH_SHORT).show();
        mScannerView.resumeCameraPreview(this);
        finish();
    }
}