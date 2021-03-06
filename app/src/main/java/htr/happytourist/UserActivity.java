package htr.happytourist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.text.DateFormat;
import java.util.Date;

/**
 * Activity to demonstrate basic retrieval of the Google user's ID, email address, and basic
 * profile.
 */
public class UserActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener {

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;
    private TextView mStatusTextView;
    private ProgressDialog mProgressDialog;
    private String personID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Views
        mStatusTextView = (TextView) findViewById(R.id.status);

        // Button listeners
        findViewById(R.id.sign_in_button).setOnClickListener(this);
        findViewById(R.id.sign_out_button).setOnClickListener(this);
        findViewById(R.id.map).setOnClickListener(this);
        findViewById(R.id.myReview).setOnClickListener(this);
        findViewById(R.id.btnInfo).setOnClickListener(this);
        findViewById(R.id.btnWeather).setOnClickListener(this);
        findViewById(R.id.btnCurrency).setOnClickListener(this);
        findViewById(R.id.btnEvents).setOnClickListener(this);


        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setScopes(gso.getScopeArray());



        //Display Time and date
        TextView mTextViewDateTime = (TextView) findViewById(R.id.textViewDateTime);
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        String happytourist = "Happy Tourist Reykjavík" + "\n" + currentDateTimeString;
        mTextViewDateTime.setText(happytourist);

    }



    @Override
    public void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d(TAG, "Got cached sign-in");
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    hideProgressDialog();
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);

        }

    }





    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            mStatusTextView.setText(acct.getDisplayName());
            personID = acct.getId();
            updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false);
        }
    }


    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]
                        updateUI(false);
                        // [END_EXCLUDE]
                    }
                });
    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    private void updateUI(boolean signedIn) {
        if (signedIn) {
            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
            findViewById(R.id.textViewFirst).setVisibility(View.GONE);

            findViewById(R.id.sign_out).setVisibility(View.VISIBLE);
            findViewById(R.id.sign_out2).setVisibility(View.VISIBLE);
            findViewById(R.id.sign_out3).setVisibility(View.VISIBLE);
            findViewById(R.id.btnCurrency).setVisibility(View.VISIBLE);
            findViewById(R.id.status).setVisibility(View.GONE);


        } else {
            mStatusTextView.setText(R.string.signed_out);

            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
            findViewById(R.id.textViewFirst).setVisibility(View.VISIBLE);

            findViewById(R.id.sign_out).setVisibility(View.GONE);
            findViewById(R.id.sign_out2).setVisibility(View.GONE);
            findViewById(R.id.sign_out3).setVisibility(View.GONE);
            findViewById(R.id.btnCurrency).setVisibility(View.GONE);
            findViewById(R.id.status).setVisibility(View.GONE);



        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.sign_out_button:
                signOut();
                break;
            case R.id.map:
                //send information to MapsActivity
                Intent mapIntent = new Intent(UserActivity.this, MapsActivity.class);
                String personName = mStatusTextView.getText().toString();
                mapIntent.putExtra("personName", personName.toString());
                mapIntent.putExtra("personID", personID);
                startActivity(mapIntent);
                break;
            case R.id.myReview:
                Intent myReviewIntent = new Intent(UserActivity.this, MyReviewsActivity.class);
                myReviewIntent.putExtra("personId", personID);
                startActivity(myReviewIntent);
                break;
            case R.id.btnInfo:
                Intent infoIntent = new Intent(v.getContext(), InfoActivity.class);
                startActivityForResult(infoIntent, 0);
                break;
            case R.id.btnWeather:
                Intent weatherIntent = new Intent(v.getContext(), WeatherActivity.class);
                startActivityForResult(weatherIntent,0);
                break;
            case R.id.btnCurrency:
                Intent currencyIntent = new Intent(v.getContext(), CurrencyActivity.class);
                startActivityForResult(currencyIntent,0);
                break;
            case R.id.btnEvents:
                Intent eventsIntent = new Intent(v.getContext(), EventActivity.class);
                startActivityForResult(eventsIntent,0);
                break;

        }
    }



}