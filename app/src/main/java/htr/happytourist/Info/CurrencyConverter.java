package htr.happytourist.Info;

/**
 * Created by hrabby on 2.3.2016.
 */
public class CurrencyConverter {
    private Currency mCurrencyShortName;
    private double mValue;

    private double mIskValue=1.0;


    private double mForeignValue;

    public enum Currency {
        ISK, USD, GBP, EUR, CAD, DKK, NOK, SEK, CHF, JPY, XDR
    }

    //Empty constructor
    public CurrencyConverter() {
    }

    public CurrencyConverter(Currency currencyShortName, double value, double iskValue, double foreignValue) {
        mCurrencyShortName = currencyShortName;
        mValue = value;
        mIskValue = iskValue;
        mForeignValue = foreignValue;
    }

    public Currency getCurrencyShortName() {
        return mCurrencyShortName;
    }

    public void setCurrencyShortName(Currency currencyShortName) {
        mCurrencyShortName = currencyShortName;
    }

    public double getValue() {
        return mValue;
    }

    public void setValue(double value) {
        mValue = value;
    }

    public double getIskValue() {
        return mIskValue;
    }

    public void setIskValue(double iskValue) {
        mIskValue = iskValue;
    }

    public double getForeignValue() {
        return mForeignValue;
    }

    public void setForeignValue(double foreignValue) {
        mForeignValue = foreignValue;
    }
}
