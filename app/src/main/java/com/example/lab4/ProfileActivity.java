package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void SetTeamIcon(View view) {
        //Creating a Return intent to pass to the Main Activity Intent returnIntent = new Intent();
        Intent returnIntent=new Intent();
        //Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;
        //Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
        //Finishing Activity and return to main screen!
        finish(); }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.logoImage);
        //Figuring out the correct image
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.logoImage00)) {
            case R.id.logoImage00:
                drawableName = "ic_logo_00";
                break;
            case R.id.logoImage01:
                drawableName = "ic_logo_01";
                break;
            case R.id.logoImage02:
                drawableName = "ic_logo_02";
                break;
            case R.id.logoImage03:
                drawableName = "ic_logo_03";
                break;
            case R.id.logoImage04:
                drawableName = "ic_logo_04";
                break;
            case R.id.logoImage05:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}