package com.example.businesscard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.DisplayPhoto
import com.example.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener { passData("Dr. Novikov","Dentist", R.drawable.doctor1)}
        binding.button2.setOnClickListener { passData("Dr. Nurmatov", "Surgeon", R.drawable.doctor2) }
        binding.button3.setOnClickListener { passData("Dr. Khalilova", "Oculist", R.drawable.doctor3) }
        binding.button4.setOnClickListener { passData("Dr. Alieva ", "Nurse", R.drawable.doctor4) }
        binding.button5.setOnClickListener { passData("Dr. Kolesova", "Doctor", R.drawable.doctor5) }
    }

    //This method is used to pass and to open the second activity
    fun passData(name: String, speciality: String, photo: Int){
        var intent = Intent(this, Activity2::class.java)
        intent.putExtra("name", name)
        intent.putExtra("speciality", speciality)
        intent.putExtra("photo", photo)
        startActivity(intent)
    }
}