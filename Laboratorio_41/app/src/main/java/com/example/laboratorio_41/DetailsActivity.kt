package com.example.laboratorio_41

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar

class DetailsActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button

    private lateinit var rootLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        btn1 = findViewById(R.id.button4);
        btn2 = findViewById(R.id.button5);

        initListeners()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 0 && grantResults.isNotEmpty()){
            for (i in grantResults.indices){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.d("TAG", "${permissions[i]} was granted")
                }
            }
        }
    }

    fun initListeners() {
        btn1.setOnClickListener {
            val phoneNum = "+5022473 7461"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNum"))
            startActivity(intent)
        }

        btn2.setOnClickListener {
            CameraPermission()
        }
    }

    private fun TrueCameraPermission() =
        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

    private fun CameraPermission() =
        if (!TrueCameraPermission()) {
            RequestRationale(android.Manifest.permission.CAMERA)
        } else{
            Toast.makeText(this, "Permiso otorgado, puedes abrir la camara", Toast.LENGTH_LONG).show()
        }

    private fun RequestRationale(permission: String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA)){
                Snackbar.make(rootLayout, "El acceso es necesario para abrir la camara", Snackbar.LENGTH_LONG).setAction("Ok"){
                    CameraPermissionrequest()
                }.show()
            } else {
                CameraPermissionrequest()
            }
        }
    }

    private fun CameraPermissionrequest() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.CAMERA), 0)
    }
}