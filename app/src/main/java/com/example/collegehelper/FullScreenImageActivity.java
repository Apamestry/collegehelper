package com.example.collegehelper;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class FullScreenImageActivity extends AppCompatActivity {
    private SubsamplingScaleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_image);

        imageView = findViewById(R.id.fullscreenImageView);

        // ✅ Get the image resource ID
        int imageRes = getIntent().getIntExtra("image_res", 0);
        if (imageRes != 0) {
            imageView.setImage(ImageSource.resource(imageRes)); // ✅ Set zoomable image
        }
    }
}
