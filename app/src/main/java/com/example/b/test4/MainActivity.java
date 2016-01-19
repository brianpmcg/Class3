package com.example.b.test4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.*;
import android.widget.Toast;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    private Button dynamicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Constants.appName, this.getClass().getCanonicalName() + ":onCreate() ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //try catch exception example
        try {
            throw new Exception("Example Exception thrown!");
        }
        catch (Exception ex){
            Log.e(Constants.appName, this.getClass().getCanonicalName() +":"+MyUtil.methodName()+ ":Exception:"+ex.getMessage());
        }

        //starting up our example service
        startService(new Intent(this, AppMonitorService.class));

        //creating a new button dynamically
        dynamicButton=new Button(this);
        dynamicButton.setText("Toast");
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayout);

        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        rl.addView(dynamicButton, lp);
        //add an onClick event listener to our button
        dynamicButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Button is clicked", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Constants.appName, this.getClass().getCanonicalName() +":"+ MyUtil.methodName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constants.appName, this.getClass().getCanonicalName() +":"+ MyUtil.methodName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constants.appName, this.getClass().getCanonicalName() +":"+ MyUtil.methodName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Log.d(Constants.appName, this.getClass().getCanonicalName() +":"+ MyUtil.methodName()+" Finishing");
        } else {
            Log.d(Constants.appName, this.getClass().getCanonicalName() +":"+MyUtil.methodName()+" Orientation");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constants.appName, this.getClass().getCanonicalName() +":"+MyUtil.methodName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constants.appName, this.getClass().getCanonicalName() +":"+MyUtil.methodName());
    }


}
