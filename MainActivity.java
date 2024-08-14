package com.example.pinball;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the PinballView as the content view
        PinballView pinballView = new PinballView(this);
        setContentView(pinballView);
    }
}
