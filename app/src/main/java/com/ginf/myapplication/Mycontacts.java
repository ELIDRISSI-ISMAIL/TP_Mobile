package com.ginf.myapplication;

import static android.app.ProgressDialog.show;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Mycontacts extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int PICK_CONTACT_REQUEST = 1;
        setContentView(R.layout.activity_mycontacts);
//        ActivityCompat.requestPermissions(this, new String[]
//                {Manifest.permission.READ_CONTACTS}, Perm_CTC);
//        super.onCreate(savedInstanceState);


        //bouton afficher les contacts
        Button btnContact = findViewById(R.id.contact);
        btnContact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts/people"));

                startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);


            }
        });

        //bouton detail contact
        Button detailsbtn = findViewById(R.id.details);
        detailsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });


            }
        });
    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[]
//            permissions, @NonNull int[] grantResults) {
//        final int Perm_CTC=12;
//
//        super.onRequestPermissionsResult(requestCode, permissions,
//                grantResults);
////check the permission type using the requestCode
//        if (requestCode == Perm_CTC) {
////the array is empty if not granted
//            if (grantResults.length > 0 && grantResults[0] ==
//                    PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(getApplicationContext(),"button clicked",Toast.LENGTH_SHORT).show();
//
//            }
//        }
//    }
  //traitement de resultat
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Button detailsbtn = findViewById(R.id.details);
        if (requestCode == 1) {
            TextView textView = findViewById(R.id.Affichage);
            if (resultCode == RESULT_OK) {

                String contactId = data.getDataString();
                textView.setText(contactId);

                detailsbtn.setVisibility(View.VISIBLE);

            } else {
                textView.setText("pas de contact selectionné");
                detailsbtn.setVisibility(View.INVISIBLE);
            }
        }

}

}
