package com.example.businesscard

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.InetAddresses
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.businesscard.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent = intent
        binding.imageDoctor.setImageResource(intent.getIntExtra("photo", 0))
        binding.textName.setText(intent.getStringExtra("name"))
        binding.textProf.setText(intent.getStringExtra("speciality"))
        binding.callCard.setOnClickListener { callAction("tel: 0557130028") }
        binding.emailCard.setOnClickListener { gmailAction("mailto:someone@gmail.com") }
        binding.webSiteCard.setOnClickListener { websiteAction("http://www.google.com") }
        binding.map.setOnClickListener { mapAction("geo:7003007619951323774") }

    }

    //This method is used to make a call
    fun callAction(uri: String){
        try {
            var call = Intent(Intent.ACTION_DIAL, Uri.parse(uri))
            startActivity(call)
        }catch (e: ActivityNotFoundException){
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT)
        }
    }

    //This method is used to go to the gmail
    fun gmailAction(uri: String){
        try {
            var gmail = Intent(Intent.ACTION_SENDTO, Uri.parse(uri))
            startActivity(gmail)
        }catch (e: ActivityNotFoundException){
            Toast.makeText(this, "Upss! Something went wrong!", Toast.LENGTH_SHORT)
        }
    }

    //It redirects user to the Website
    fun websiteAction(uri: String){
        try {
            var website = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(website)
        }catch (e: ActivityNotFoundException){
            Toast.makeText(this, "Nooo", Toast.LENGTH_SHORT)
        }
    }

    //It opens map
    fun mapAction(uri: String){
        try {
            var map = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            map.setPackage("com.google.android.apps.maps")
            startActivity(map)
        }catch (e: ActivityNotFoundException){
            Toast.makeText(this, "Can't open it", Toast.LENGTH_SHORT)
        }
    }

}