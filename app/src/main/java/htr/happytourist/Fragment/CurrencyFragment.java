package htr.happytourist.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.*;
import android.widget.*;


import htr.happytourist.Info.CurrencyConverter;
import htr.happytourist.Info.CurrencyConverter.*;
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
                String spinVal = String.valueOf(mSpinnerCurrency.getSelectedItem());
                Currency mCurrencyShortName = Currency.valueOf(spinVal);
                mCurrencyConverter.setCurrencyShortName(mCurrencyShortName);

                Double mISKValue;
                mISKValue = Double.parseDouble(mIskValueText.getText().toString());
                mCurrencyConverter.setIskValue(mISKValue);
                mCurrencyConverter.setForeignValue(mISKValue);


                mCurrencyConverterService = new CurrencyConverterService();

                mCurrencyConverterService.getValue(mCurrencyConverter);
                mCurrencyConverterService.calculateCurrency(mCurrencyConverter);

                String name = Double.toString(mCurrencyConverter.getForeignValue());

                mForeignValueView.setText(name);


            }
        });


        return v;
    }


}
