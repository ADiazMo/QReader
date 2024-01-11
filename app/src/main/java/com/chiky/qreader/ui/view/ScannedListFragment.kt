package com.chiky.qreader.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chiky.qreader.R
import com.chiky.qreader.data.model.Scanned
import com.chiky.qreader.data.remote.ScannedProvider
import com.chiky.qreader.databinding.FragmentScannedBinding
import com.chiky.qreader.databinding.FragmentScannedListBinding
import com.chiky.qreader.ui.adapter.ScannedAdapter
import com.chiky.qreader.ui.viewModel.ScannedListViewModel


class ScannedListFragment : Fragment() {

    private var _binding: FragmentScannedListBinding? = null
    private val binding get() = _binding!!
    private lateinit var listScannedViewModel: ScannedListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScannedListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        InitRecyclerView()
        // Initialize ViewModel
        listScannedViewModel = ViewModelProvider(this).get(ScannedListViewModel::class.java)

        // Observe changes in userLiveData
        //userViewModel.userLiveData.observe(viewLifecycleOwner, Observer { user ->
            // Update UI with user data

        //    textViewUserName.text = user.name
        //})

        // Fetch user data
        //userViewModel.fetchUserData()
    }

    private fun InitRecyclerView(){
        val manager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity,manager.orientation)

        binding.rcScanned.layoutManager = manager
        binding.rcScanned.adapter = ScannedAdapter(ScannedProvider.scannedList){ scanned ->
            onItemSelected(
                scanned
            )
        }
        binding.rcScanned.addItemDecoration(decoration)

    }
    fun onItemSelected(scanned: Scanned){
        Toast.makeText(context,scanned.title, Toast.LENGTH_LONG).show()
    }

    companion object{
        @JvmStatic
        fun newInstance() = ScannedListFragment().apply {  }
    }
}