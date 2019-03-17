package com.example.encryanddecry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.utillibrary.RSAUtils;

import org.apaches.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RsaDemo();
    }
    public static final String PUBLIC_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALhe9LXYzikAGj3DWN+O4fIvsMjLgUoXEDJEMTfP5mFBigoKn04Rhg6ouGejC1W2nOVcUkAJDoNJp8JjQ7s/S1kCAwEAAQ==";
    public static final String PRIVATE_KEY = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAuF70tdjOKQAaPcNY347h8i+wyMuBShcQMkQxN8/mYUGKCgqfThGGDqi4Z6MLVbac5VxSQAkOg0mnwmNDuz9LWQIDAQABAkAGi1ZP0x2EPozv5sxziQCTpmY1xmV1Mgrg4eNGWiKRDqFRKDRt61HUYNLhaaDvXKQwsQSHe85utROwu1tydI2hAiEA3LTRkyDRdJ87iuUDA9kdvhzz5l2KVzU5B4WKf3l7nokCIQDV2qdxrsb8zpLsZADOWFr2WgGqv+4tP21vetOFBviSUQIgB0jEffmgUBwNSAlE7zSUQbkM57aAoV41UqU6q/hjdxkCIQCdhRZLPXLi6gH8z1hspVYzGW8a5463k323XKCK3uyfUQIgUTB0jG9Kr+1vADkStsxcqwXjinOQknnA+PppGcRK4hc=";

    private void RsaDemo() {

        String orignalData = "http://www.baidu.com/";

        KeyPair keyPair = RSAUtils.createKeys(512);
        PublicKey aPublic = keyPair.getPublic();
        PrivateKey aPrivate = keyPair.getPrivate();
        /**
         * 公钥加密，私钥解密
         */

        String pubKeyTartget = Base64.encodeBase64String(aPublic.getEncoded());
        Log.e("lpc000", "公钥：" + pubKeyTartget);

        try {
            String privateKeyTarget = Base64.encodeBase64String(aPrivate.getEncoded());
            Log.e("lpc000", "私钥：" + privateKeyTarget);
            String encryData = RSAUtils.publicEncrypt(orignalData, RSAUtils.getPublicKey(PUBLIC_KEY));
            String newData = "insuranceH5:"+encryData+":请使用启辰智联APP扫码";
            Log.e("lpc000", "加密后的数据: " + newData);

            String decryData = RSAUtils.privateDecrypt(encryData, RSAUtils.getPrivateKey(PRIVATE_KEY));

            Log.e("lpc000", "解密后的数据: " + decryData);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }





}
