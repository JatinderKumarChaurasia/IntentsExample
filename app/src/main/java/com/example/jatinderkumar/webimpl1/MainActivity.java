package com.example.jatinderkumar.webimpl1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3,btn4;
    ImageView imageView;
    private static final int TAG = 234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView =(ImageView) findViewById(R.id.img1);
        //btn1 = (Button) findViewById(R.id.btn1);
        //btn2 = (Button) findViewById(R.id.btn2);
        // btn3 = (Button) findViewById(R.id.btn3);

    }

    public void web(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.co.in/"));
        startActivity(intent);

    }

    @SuppressLint("MissingPermission")
    public void phone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+880217769));
        startActivity(intent);
    }

    public void mapp(View view) {

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (location != null) {
                    Log.d("LOCATION CHANGED", 344 + "");
                    Log.d("LOCATION CHANGED", 355 + "");
                    Toast.makeText(MainActivity.this,
                            location.getLatitude() + "" + location.getLongitude(),
                            Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 223, 230, locationListener);

    }

    public void cam(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    44);
        }
        startActivityForResult(intent,44);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 44)
        {

            Bitmap bitmap =(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}
