package com.example.mk.changingsize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        final PhotoView view = findViewById(R.id.photo_view);

        Button button = findViewById(R.id.change_size);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCount == 0) {
                    mCount++;

                    view.cropSquare(mCount);

                } else {
                    if (mCount == 1) {
                        mCount++;


                    }
                }
            }
        });
    }
}
