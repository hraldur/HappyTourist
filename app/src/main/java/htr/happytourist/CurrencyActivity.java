package htr.happytourist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import htr.happytourist.Fragment.CurrencyFragment;

public class CurrencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.currencyContainer, new CurrencyFragment()).commit();
        }
    }

}

