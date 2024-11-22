package com.gowtham.androidtraining;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText etTitle,etDescription,etJourner,etRatings,etDuration;
    TextView tvResult;
    AppCompatButton btnSubmit;
    private Button logout;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getApplicationContext().getSharedPreferences("LOGIN_PREF", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        etDuration = findViewById(R.id.etDuration);
        etJourner = findViewById(R.id.etJourner);
        etRatings = findViewById(R.id.etRatings);

        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        logout = findViewById(R.id.btnLogout);

        logout.setOnClickListener(view->{

            editor.remove("username");
            ///editor.clear();
            editor.commit();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        });

        etRatings.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(actionId == EditorInfo.IME_ACTION_DONE)
                {
                    submitForm();
                    return true;
                }
                return false;
            }
        });




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //loading();
                //submitForm();
                //confirmation();
                loadings();

            }
        });


    }

    private void loadings(){
        BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCancelable(false);
        Button btnClose = dialog.findViewById(R.id.btnCloseDialog);
        btnClose.setOnClickListener(view -> dialog.dismiss());
        dialog.show();

    }

    private void loading(){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCancelable(false);
        Button btnClose = dialog.findViewById(R.id.btnCloseDialog);
        btnClose.setOnClickListener(view -> dialog.dismiss());
        dialog.show();
    }

    private void confirmation(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Confirmation");
        alertDialog.setMessage("Do you want to submit?");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                submitForm();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Form Submit is Cancelled by user",Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setNeutralButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Neutralized",Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    }


    private void submitForm() {
        String name = etTitle.getText().toString();
        boolean isValid = true;
        if(TextUtils.isEmpty(name))
        {
            etTitle.setError("Required Field");
            isValid = false;
            //Toast.makeText(getApplicationContext(), "Please enter your title", Toast.LENGTH_SHORT).show();
            //return;
        }
        String description = etDescription.getText().toString();

        if(TextUtils.isEmpty(description))
        {
            etDescription.setError("Required Field");
            isValid = false;
            //Toast.makeText(getApplicationContext(), "Please enter your description", Toast.LENGTH_SHORT).show();
            //return;
        }

        String journers = etJourner.getText().toString();
        if(TextUtils.isEmpty(journers))
        {
            etJourner.setError("Required Field");
            isValid = false;
            //Toast.makeText(getApplicationContext(), "Please enter your journer", Toast.LENGTH_SHORT).show();
            //return;
        }

        String duration = etDuration.getText().toString();
        if(TextUtils.isEmpty(duration)){
            etDuration.setError("Required Field");
            isValid = false;
            //Toast.makeText(getApplicationContext(), "Please enter your duration", Toast.LENGTH_SHORT).show();
            //return;
        }

        String ratings = etRatings.getText().toString();
        if(TextUtils.isEmpty(ratings)){
            etRatings.setError("Required Field");
            isValid = false;
            //Toast.makeText(getApplicationContext(), "Please enter your ratings", Toast.LENGTH_SHORT).show();
            //return;
        }

        if(!isValid)
            return;

        Movies movies = new Movies();
        movies.setTitle(name);
        movies.setDescription(description);
        movies.setDuration(Integer.parseInt(duration));
        movies.setJourner(journers);
        movies.setRating(ratings);


        Intent intent = new Intent(MainActivity.this, TicketActivity.class);
        intent.putExtra("movies",movies);

        //intent.putParcelableArrayListExtra("movies",new ArrayList<Movies>());

        startActivityForResult(intent,100);
        //startActivity(intent);
        //finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100)
        {
            if(resultCode == RESULT_OK)
            {
                String result = data.getStringExtra("result");
                tvResult.setText(result);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }
}