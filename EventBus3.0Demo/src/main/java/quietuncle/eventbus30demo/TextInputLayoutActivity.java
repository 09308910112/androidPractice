package quietuncle.eventbus30demo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 */

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout userName;
    private TextInputLayout password;
    private Button btnLogin;
    private EditText etUserName;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        initView();
        initListener();
    }

    private void initListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    /**
     * 登录操作
     */
    private void login() {
        boolean isPwdValidate = valideatePassword(etPassword.getText().toString());
        if (isPwdValidate) {
            Snackbar.make(btnLogin, "登录成功", Snackbar.LENGTH_LONG).setAction("点击事件", new View
                    .OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(TextInputLayoutActivity.this, "你点击了snackBar", Toast.LENGTH_SHORT).show();
                }
            }).setDuration(Snackbar.LENGTH_LONG).show();
            userName.setErrorEnabled(false);
            password.setErrorEnabled(false);
        } else {
            userName.setErrorEnabled(true);
            password.setErrorEnabled(true);
            password.setError("password is too short");
        }
    }

    private void initView() {
        etUserName = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        userName = findViewById(R.id.t1_username);
        password = findViewById(R.id.t1_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    public boolean valideatePassword(String pwd) {
        return pwd.length() > 6;
    }
}
