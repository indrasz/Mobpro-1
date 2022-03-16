package org.d3if4404.galerihewan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import org.d3if4404.galerihewan.adapter.MainAdapter
import org.d3if4404.galerihewan.databinding.ActivityMainBinding
import org.d3if4404.galerihewan.model.Hewan

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.recyclerView){
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = MainAdapter(getData())
            setHasFixedSize(true)
        }

    }

    private fun getData(): List<Hewan> {
        return listOf(
            Hewan("Angsa", "Cygnus olor", "Unggas", R.drawable.angsa),
            Hewan("Ayam", "Gallus gallus", "Unggas", R.drawable.ayam),
            Hewan("Bebek", "Cairina moschata", "Unggas", R.drawable.bebek),
            Hewan("Domba", "Ovis ammon", "Mamamlia", R.drawable.domba),
            Hewan("Kalkun", "Meleagris gallopavo", "Unggas", R.drawable.kalkun),
            Hewan("Kambing", "Capricornis sumatrensis", "Mamalia", R.drawable.kambing),
            Hewan("Kelinci", "Oryctolagus cuniculus", "Mamalia", R.drawable.kelinci),
            Hewan("Kerbau", "Bubalus bubalis", "Mamalia", R.drawable.kerbau),
            Hewan("Kuda", "Equus caballus", "Mamalia", R.drawable.kuda),
            Hewan("Sapi", "Bos taurus", "Mamalia", R.drawable.sapi),
        )
    }
}