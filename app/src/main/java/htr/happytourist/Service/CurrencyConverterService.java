package htr.happytourist.Service;

import org.json.JSONException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import htr.happytourist.Data.GetData;
import htr.happytourist.Info.CurrencyConverter;
import htr.happytourist.Info.CurrencyConverter.Currency;

/**
 * Created by hrabby on 2.3.2016.
 */
public class CurrencyConverterService {


    public CurrencyConverterService() {

    }


    public ArrayList<CurrencyConverter> getCurrencyConverters()throws ParseException, IOException, JSONException {
        String a = "currency";
        GetData data = new GetData(a);
        CurrencyConverter[] currencyConverters = data.createCurrencyConverter();
        ArrayList<CurrencyConverter> currencyList = new ArrayList<>(Arrays.asList(currencyConverters));
        return currencyList;
    }



    public double findValue(CurrencyConverter currencyConverter){
        ArrayList<CurrencyConverter> currencyConverters = null;
        try {
            currencyConverters = getCurrencyConverters();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        double value = 1;
        for(int i = 0; i < currencyConverters.size(); i++){
            if(currencyConverter.getCurrencyShortName() == Currency.values()[i]){

                value = currencyConverters.get(i).getValue();
                currencyConverter.setValue(value);
            }
        }
        return value;
    }



    public double calculateCurrency(CurrencyConverter currencyConverter) {
        //get exchange rate for selected currency
        findValue(currencyConverter);


        double iskValue = currencyConverter.getIskValue();
        double value = currencyConverter.getValue();
        double foreignValue = iskValue/value;
        currencyConverter.setForeignValue(foreignValue);

        return currencyConverter.getForeignValue();
    }




}

