package com.example.grehighfrequencywords.feed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.grehighfrequencywords.R
import com.example.grehighfrequencywords.feed.data.Word

class WordAdapter(context: FragmentActivity, private val resourceId: Int, val data: List<Word>)
    : ArrayAdapter<Word>(context, resourceId, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.word_view, parent, false)
        val word = view.findViewById<TextView>(R.id.wordId)
        val wordMeaning = view.findViewById<TextView>(R.id.wordMeaningId)

        val curWord= data[position]
        if (curWord != null) {
            word.text = curWord.word
            wordMeaning.text = curWord.meaning
        }

        return view
    }
}