package com.dimakaplin143.margins;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String lang;
    private int theme;
    private Spinner langSpinner;
    private Spinner themeSpinner;
    private Button btnOk;
    private Button btnOkMargin;
    Locale locale;
    Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        langSpinner = findViewById(R.id.spinner);
        themeSpinner = findViewById(R.id.spinner_theme);

        initSpinnerLang();
        initSpinnerTheme();
        btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(v-> {
            switch (lang) {
                case "Ру":
                    locale = new Locale("ru");
                    Utils.changeLang(Arrays.asList(getResources().getStringArray(R.array.lang)).indexOf(lang));
                    config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                    break;
                case "En":
                    locale = new Locale("en");
                    Utils.changeLang(Arrays.asList(getResources().getStringArray(R.array.lang)).indexOf(lang));
                    config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                    break;
            }
        });
        btnOkMargin = findViewById(R.id.btn_ok_margin);
        btnOkMargin.setOnClickListener(v-> {
            switch (theme) {
                case 0:
                    Utils.changeToTheme(this, Utils.THEME_FIRST);
                    break;
                case 1:
                    Utils.changeToTheme(this, Utils.THEME_SECOND);
                    break;
                case 2:
                    Utils.changeToTheme(this, Utils.THEME_THIRD);
                    break;
            }
        });

    }

    private void initSpinnerLang() {
        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this, R.array.lang, android.R.layout.simple_spinner_item);
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSpinner.setAdapter(adapterLang);
        langSpinner.setSelection(Utils.getLang());

        langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] locales = getResources().getStringArray(R.array.lang);
                lang = locales[i];

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    private void initSpinnerTheme() {
        ArrayAdapter<CharSequence> adapterTheme = ArrayAdapter.createFromResource(this, R.array.themes, android.R.layout.simple_spinner_item);
        adapterTheme.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSpinner.setAdapter(adapterTheme);
        themeSpinner.setSelection(Utils.getTheme());

        themeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                theme = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
