package com.chiky.qreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chiky.qreader.databinding.ActivityMainBinding
import com.chiky.qreader.ui.view.ScannedFragment
import com.chiky.qreader.ui.view.ScannedListFragment
import com.chiky.qreader.ui.view.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var scanFragment: ScannedFragment
    private lateinit var scanListFragment: ScannedListFragment
    private lateinit var settingFragment: SettingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Setting()
        Listener()
        InitialFragment()
    }

    private fun InitialFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentPlace, scanFragment, "scanfragment")
            .commit()
    }
    private fun Listener(): Boolean{
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.nav_scan -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentPlace, scanFragment, "scanfragment")
                        .commit()
                }
                R.id.nav_list -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentPlace, scanListFragment, "scanlistfragment")
                        .commit()
                }
                R.id.nav_setting -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentPlace, settingFragment, "settingfragment")
                        .commit()
                }
            }
            true
        }
        return true
    }

    private fun Setting(){
        scanFragment = ScannedFragment.newInstance()
        scanListFragment = ScannedListFragment.newInstance()
        settingFragment = SettingFragment.newInstance()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        supportFragmentManager.findFragmentByTag("scanfragment")
            ?.onActivityResult(requestCode, resultCode, data)


        /*
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "El valor escaneado es: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }

         */
    }


}