package com.isroot.ActivityResultContractsPermissionRequest

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.CAMERA
    )

    private val requestPermission = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) {
            for(entry in it.entries) {
                Toast.makeText(
                    this,
                    "${entry.key} = ${entry.value}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)

        tv.setOnClickListener {
            requestPermission.launch(
                permissions
            )
        }
    }
}