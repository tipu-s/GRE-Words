package com.example.grehighfrequencywords.feed.ui

import WordFragmentViewModelFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.grehighfrequencywords.R
import com.example.grehighfrequencywords.feed.adapter.WordAdapter
import com.example.grehighfrequencywords.feed.data.MyRepository
import com.example.grehighfrequencywords.feed.data.RetrofitInstance
import com.example.grehighfrequencywords.feed.util.LogUtil
import com.example.grehighfrequencywords.feed.viewmodel.WordFragmentViewModel

class WordFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var wordAdapter: WordAdapter
    private lateinit var wordFragmentViewModel: WordFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_word, container, false)

        val myRepository = MyRepository(RetrofitInstance.getRetrofitInstance())
        wordFragmentViewModel = ViewModelProvider(this, WordFragmentViewModelFactory(myRepository))[WordFragmentViewModel::class.java]
        wordFragmentViewModel.loadData()

        wordFragmentViewModel.wordList.observe(viewLifecycleOwner) {
            wordAdapter = WordAdapter(requireActivity(), R.id.listView, it)
            listView = rootView.findViewById(R.id.listView)
            listView.adapter = wordAdapter
        }

        wordFragmentViewModel.error.observe(viewLifecycleOwner, Observer {
            LogUtil.d(it.toString())
        })

        return rootView
    }
}