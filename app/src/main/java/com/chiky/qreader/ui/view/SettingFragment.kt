package com.chiky.qreader.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chiky.qreader.R
import com.chiky.qreader.ui.viewModel.ScannedViewModel
import com.chiky.qreader.ui.viewModel.SettingViewModel

class SettingFragment: Fragment() {

    private lateinit var settingViewModel: SettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        settingViewModel = ViewModelProvider(this).get(SettingViewModel::class.java)

        // Observe changes in userLiveData
        //userViewModel.userLiveData.observe(viewLifecycleOwner, Observer { user ->
        // Update UI with user data

        //    textViewUserName.text = user.name
        //})

        // Fetch user data
        //userViewModel.fetchUserData()
    }

    companion object{
        @JvmStatic
        fun newInstance() = SettingFragment().apply {  }
    }
}