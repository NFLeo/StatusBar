package com.leo.project.statusbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private Button btnMain;
    private Button btnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ScreenUtils.translateSetTextColerStatusBar(this);

        btnMain = findViewById(R.id.btn_main);
        btnImage = findViewById(R.id.btn_image);

        btnMain.setVisibility(View.VISIBLE);
        btnImage.setVisibility(View.VISIBLE);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, ImageActivity.class));
            }
        });
    }
}
