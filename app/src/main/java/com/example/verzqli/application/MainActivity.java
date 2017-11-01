package com.example.verzqli.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import leetcode.TheMedianOfTwoSortedArray;
import widget.RoundRectTextView;

import static android.util.Log.i;

public class MainActivity extends AppCompatActivity {
    private RoundRectTextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i("git stash", "1");

        textView = (RoundRectTextView) findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("zz", "onClick: ");
            }
        });
        int a[] = {1,2,5,7,9,11};
        int b[]={2,4,5,8,};
        Log.i("zz", "onCreate: "+ TheMedianOfTwoSortedArray.findMedianSortedArrays(a,b));
    }
}
