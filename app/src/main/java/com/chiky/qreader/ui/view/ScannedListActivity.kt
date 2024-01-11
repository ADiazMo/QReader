package com.chiky.qreader.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.chiky.qreader.R
import com.chiky.qreader.data.model.Scanned
import com.chiky.qreader.data.remote.ScannedProvider
import com.chiky.qreader.databinding.ActivityMainBinding
import com.chiky.qreader.databinding.ActivityScannedListBinding
import com.chiky.qreader.ui.adapter.ScannedAdapter

class ScannedListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScannedListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannedListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun InitRecyclerView(){
        binding.rcScanned.layoutManager = LinearLayoutManager(this)
        binding.rcScanned.adapter = ScannedAdapter(ScannedProvider.scannedList){ scanned ->
            onItemSelected(
                scanned
            )
        }
    }
    fun onItemSelected(scanned: Scanned){
        Toast.makeText(this,scanned.title,Toast.LENGTH_LONG).show()
    }
}