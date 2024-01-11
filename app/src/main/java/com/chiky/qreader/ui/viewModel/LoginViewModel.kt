package com.chiky.qreader.ui.viewModel

import androidx.lifecycle.ViewModel
import com.chiky.qreader.data.model.Candidate
import com.chiky.qreader.data.model.Login
import com.chiky.qreader.data.remote.CandidateProvider
import com.chiky.qreader.util.MyApplication

class LoginViewModel : ViewModel() {

    fun LoginCandidate(login: Login): Boolean{
        val candidate = Candidate(1,"Agustín","Díaz",login.nickName,"+34637000000")
        MyApplication().currentUser = candidate // CandidateProvider.candidate
        return true
    }
}