package com.leo.project.statusbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ScreenUtils.translateSetTextColerStatusBar(this);
        ImageView view = findViewById(R.id.view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseBottomDialog dialogFragment = BaseBottomDialog.newInstance(R.layout.content_main);
                dialogFragment.show(getSupportFragmentManager(), "dialogFragment");
            }
        });
    }
}
