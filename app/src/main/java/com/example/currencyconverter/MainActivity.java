package com.example.currencyconverter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;






public class MainActivity extends AppCompatActivity {


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }





    public void bFunction(View view){
        Log.i("info","convert");
        EditText amountEditText = findViewById(R.id.amountEditText);
        Log.i("amountEditText" ,amountEditText.getText().toString());
        String amountInDollars = amountEditText.getText().toString();
        double amountInDollarsDouble = Double.parseDouble(amountInDollars);
        double amountInEgpDouble = amountInDollarsDouble * 19.61;
        String amountInEgpString = String.format("%.2f", amountInEgpDouble);
        Log.i("info","amount in Egp is "+ amountInEgpString);
        Toast.makeText(this,amountInDollars +" $ = " + amountInEgpString +" EGP", Toast.LENGTH_SHORT).show();





    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.black));

        }
    }
