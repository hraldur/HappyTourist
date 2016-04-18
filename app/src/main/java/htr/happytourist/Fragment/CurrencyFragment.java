package htr.happytourist.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import htr.happytourist.Info.CurrencyConverter;
import htr.happytourist.Info.CurrencyConverter.Currency;
import htr.happytourist.R;
import htr.happytourist.Service.CurrencyConverterService;

public class CurrencyFragment extends Fragment {

    private CurrencyConverter mCurrencyConverter;
    private CurrencyConverterService mCurrencyConverterService;
    EditText mIskValueText;
    TextView mForeignValueView;
    Button mBtnCurrency;
    Spinner mSpinnerCurrency;

    public CurrencyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_currency, container, false);

        mIskValueText = (EditText) v.findViewById(R.id.textIskValue);
        mForeignValueView = (TextView) v.findViewById(R.id.viewForeignValue);
        mSpinnerCurrency = (Spinner) v.findViewById(R.id.spinnerCurrency);
        mBtnCurrency = (Button) v.findViewById(R.id.btnCurrency);
        mBtnCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrencyConverter = new CurrencyConverter();
                mCurrencyConverterService = new CurrencyConverterService();

                //select currency
                String spinVal = String.valueOf(mSpinnerCurrency.getSelectedItem());
                Currency mCurrencyShortName = Currency.valueOf(spinVal);
                mCurrencyConverter.setCurrencyShortName(mCurrencyShortName);

                //get iskValue, input value
                Double mISKValue;
                mISKValue = Double.parseDouble(mIskValueText.getText().toString());
                mCurrencyConverter.setIskValue(mISKValue);

                //convert amount to selected currency
                mCurrencyConverterService.calculateCurrency(mCurrencyConverter);
                Double foreignCurrency = mCurrencyConverter.getForeignValue();
                DecimalFormat foreign = new DecimalFormat("#.##");
                foreign.setRoundingMode(RoundingMode.CEILING);
                String foreignValue = foreign.format(foreignCurrency);
                mForeignValueView.setText(foreignValue);

            }
        });


        return v;
    }


}
