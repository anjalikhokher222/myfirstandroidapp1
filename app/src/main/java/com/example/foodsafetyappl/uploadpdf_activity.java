package com.example.foodsafetyappl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.nio.file.attribute.UserPrincipalLookupService;

public class uploadpdf_activity<onActivityResult> extends AppCompatActivity {
    EditText editPDFName;
    Button btn_upload;
    StorageReference storageReference;
    DatabaseReference databaseReference;

Button viewbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadpdf_activity);
        editPDFName = (EditText)findViewById(R.id.editpdf);

        btn_upload = (Button)findViewById(R.id.button7);
        viewbutton = (Button)findViewById(R.id.button8);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDFFile();


            }
        });
        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),MyRecyclerViewActivity.class));

            }
        });



    }

    private void selectPDFFile() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF File"), 1);

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data !=null && data.getData()!=null) {

            uploadPDFFile(data.getData());



        }

        }
        private void uploadPDFFile(Uri data){
            final ProgressDialog progressDialog=new ProgressDialog(this);
            progressDialog.setTitle("Uploading");
            progressDialog.show();



        StorageReference reference=storageReference.child("uploads/"+System.currentTimeMillis()+"");
        reference.putFile(data)
        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uri=taskSnapshot.getStorage().getDownloadUrl();
                while(!uri.isComplete());
                Uri url=uri.getResult();

                uploadPDF uploadPDF=new uploadPDF(editPDFName.getText().toString(),url.toString());
                databaseReference.child(databaseReference.push().getKey()).setValue(uploadPDF);
                Toast.makeText(uploadpdf_activity.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();






            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
        progressDialog.setMessage("Uploaded:"+(int)progress+"%");






            }
        });


        }








}