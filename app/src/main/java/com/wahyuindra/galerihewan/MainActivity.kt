package com.wahyuindra.galerihewan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wahyuindra.galerihewan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val hewan = listOf("Ayam", "Bebek", "Domba", "Kambing", "Sapi")
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener{
            showNext()
        }

        binding.btnBack.setOnClickListener{
            showBack()
        }
    }

    private fun showNext(){
//        Log.d("MainActivity", "Tombol diklik")
        index = if (index == hewan.size-1) 0 else index + 1
        binding.tvHewan.text = hewan[index]

        val imageResource = when (index){
            1 -> R.drawable.bebek
            2 -> R.drawable.domba
            3 -> R.drawable.kambing
            4 -> R.drawable.sapi
            else -> R.drawable.ayam
        }
        binding.ivHewan.setImageResource(imageResource)

    }

    private fun showBack(){
        binding.tvHewan.text = hewan[0]
        val imageResource = R.drawable.ayam
        binding.ivHewan.setImageResource(imageResource)
    }

}