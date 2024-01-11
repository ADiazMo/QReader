package com.chiky.qreader.ui.viewModel

import androidx.lifecycle.ViewModel
import com.chiky.qreader.data.model.Login
import com.chiky.qreader.data.remote.CandidateProvider
import com.chiky.qreader.util.MyApplication

class RegisterViewModel: ViewModel() {
    fun RegisterCandidate(){
        MyApplication().currentUser = CandidateProvider.candidate
    }
}