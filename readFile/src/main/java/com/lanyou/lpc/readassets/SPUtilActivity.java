package com.lanyou.lpc.readassets;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SPUtilActivity extends PreferenceActivity {

    private Button btnRead;
    private Button btnWrite;
    private EditText etInput;
    private SharedPreferences.Editor edit;
    private SharedPreferences preferences;
    private PreferenceManager manager;
    private CheckBoxPreference checkbox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.mypreference);
        manager = getPreferenceManager();
        checkbox1 = (CheckBoxPreference) manager.findPreference("checkbox1");
        final EditTextPreference editTextPreference = (EditTextPreference) manager.findPreference("edittext");
        final ListPreference list = (ListPreference) manager.findPreference("list");

        list.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                list.setSummary(list.getValue());
                Toast.makeText(SPUtilActivity.this, list.getEntry()+", "+list.getValue()+","+newValue, Toast.LENGTH_SHORT)
                        .show();
                return true;
            }
        });

        checkbox1.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Toast.makeText(SPUtilActivity.this,""+ checkbox1.isChecked(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        Toast.makeText(this,""+   editTextPreference.getText().toString(), Toast.LENGTH_SHORT).show();


      list.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
          @Override
          public boolean onPreferenceChange(Preference preference, Object newValue) {
              list.setSummary(newValue.toString());
              return true;
          }
      });

        editTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String content = editTextPreference.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("content",content);
                editTextPreference.setSummary(newValue.toString());
              //  setResult(200,intent);
                return true;
            }
        });
      /*setContentView(R.layout.activity_sputil);
      initView();
        initEvent();
        initSP();*/
    }

    private void initSP() {
        preferences = getSharedPreferences("SP_NAME", Context.MODE_PRIVATE);
        edit = preferences.edit();
    }

    private void initEvent() {
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SPUtilActivity.this, preferences.getString("params","no no no"),
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putString("params",etInput.getText().toString());
                edit.apply();
            }
        });
    }

    private void initView() {
        btnRead = findViewById(R.id.btn_read);
        btnWrite = findViewById(R.id.btn_write);
        etInput = findViewById(R.id.et_input);
    }
}
