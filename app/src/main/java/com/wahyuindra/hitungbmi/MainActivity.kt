package com.wahyuindra.hitungbmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.wahyuindra.hitungbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button.setOnClickListener{
                hitungBmi()
            }
            btnReset.setOnClickListener{
                setView()
            }
        }
    }

    private fun hitungBmi(){
        val berat = binding.beratEditText.text.toString()
        if (TextUtils.isEmpty(berat)) {
            binding.beratEditText.requestFocus()
            Toast.makeText(this, R.string.berat_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val tinggi = binding.tinggiEditText.text.toString()
        if (TextUtils.isEmpty(tinggi)) {
            binding.tinggiEditText.requestFocus()
            Toast.makeText(this, R.string.tinggi_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val tinggiCm = tinggi.toFloat() / 100
        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, R.string.gender_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val isMale = selectedId == R.id.priaRadioButton
        val bmi = berat.toFloat() / (tinggiCm * tinggiCm)
        val kategori = getKategori(bmi, isMale)
        binding.apply {
            bmiTextView.text = getString(R.string.bmi_x, bmi)
            kategoriTextView.text = getString(R.string.kategori_x, kategori)
        }

    }

    private fun getKategori(bmi: Float, isMale: Boolean): String {
        val stringRes = if (isMale) {
            when {
                bmi < 20.5 -> R.string.kurus
                bmi >= 27.0 -> R.string.gemuk
                else -> R.string.ideal
            }
        } else {
            when {
                bmi < 18.5 -> R.string.kurus
                bmi >= 25.0 -> R.string.gemuk
                else -> R.string.ideal
            }
        }
        return getString(stringRes)
    }

    private fun setView(){
        binding.apply {
            beratEditText.text.clear()
            tinggiEditText.text.clear()
            radioGroup.clearCheck()
            bmiTextView.text = " "
            kategoriTextView.text = " "
        }
    }

}