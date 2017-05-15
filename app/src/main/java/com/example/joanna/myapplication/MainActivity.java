package com.example.joanna.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //add TAG for log
    public static final String TAG = MainActivity.class.getSimpleName();
    //declare our view variables
    private GetFact mGetFact=new GetFact();
    private ColorWheel mColorWheel=new ColorWheel();
    private TextView mtextView;
    private Button mShowButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign new line for the layout
        mtextView=(TextView) findViewById(R.id.textView);
        mShowButton=(Button)findViewById(R.id.button);
        mRelativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the button was clicked, update with text view
                String fact=mGetFact.generateFact();
                String color=mColorWheel.getColor();
                mtextView.setText(fact);
                mRelativeLayout.setBackgroundColor(Color.parseColor(color));
                mShowButton.setTextColor(Color.parseColor(color));
            }
        };
        mShowButton.setOnClickListener(listener);

        /*
        The second parameter is a CharSequence for the text we'd like to show in our Toast.
        LENGTH_SHORT will show our Toast for two seconds, and LENGTH_LONG will show it for three and half
         */
       // Toast.makeText(MainActivity.this,"create successfully",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"logging from onCreat methods");
    }
}
