package com.chiky.qreader.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chiky.qreader.R
import com.chiky.qreader.databinding.FragmentScannedBinding
import com.chiky.qreader.ui.viewModel.ScannedListViewModel
import com.chiky.qreader.ui.viewModel.ScannedViewModel
import com.google.zxing.integration.android.IntentIntegrator

class ScannedFragment: Fragment() {

    private var _binding:FragmentScannedBinding? = null
    private val binding get() = _binding!!

    private lateinit var scannedViewModel: ScannedViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScannedBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScanner.setOnClickListener { initScanner() }

        // Initialize ViewModel
        scannedViewModel = ViewModelProvider(this).get(ScannedViewModel::class.java)

        // Observe changes in userLiveData
        //userViewModel.userLiveData.observe(viewLifecycleOwner, Observer { user ->
        // Update UI with user data

        //    textViewUserName.text = user.name
        //})

        // Fetch user data
        //userViewModel.fetchUserData()
    }

    fun initScanner(){
        val integrator = IntentIntegrator(activity)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Infoempleo Scan")
        integrator.setTorchEnabled(false)//linterna
        integrator.setBeepEnabled(true)//sonido
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(activity, "Cancelado", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "El valor escaneado es: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }


    companion object{
        @JvmStatic
        fun newInstance() = ScannedFragment().apply {  }
    }
}