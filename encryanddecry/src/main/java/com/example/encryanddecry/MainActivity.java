package com.example.encryanddecry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.apaches.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
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

    private void RsaDemo() {
        String orignalData = "maomao";

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
            String encryData = RSAUtils.publicEncrypt(orignalData, RSAUtils.getPublicKey(pubKeyTartget));

            Log.e("lpc000", "加密后的数据: " + encryData);

            String decryData = RSAUtils.privateDecrypt(encryData, RSAUtils.getPrivateKey(privateKeyTarget));

            Log.e("lpc000", "解密后的数据: " + decryData);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }


}
