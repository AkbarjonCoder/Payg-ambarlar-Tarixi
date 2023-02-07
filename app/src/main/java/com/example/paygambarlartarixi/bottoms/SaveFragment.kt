package com.example.paygambarlartarixi.bottoms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paygambarlartarixi.R
import com.example.paygambarlartarixi.adapter.Adapter
import com.example.paygambarlartarixi.database.SaveData
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.paygambarlartarixi.room.ViewModel

class SaveFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save, container, false)
    }
    private val viewModel : ViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rvc = requireActivity().findViewById<RecyclerView>(R.id.rv3)

        viewModel.getData.observe(requireActivity(), Observer {
            var save = ArrayList<SaveData>()
            for (i in it.indices){
                save.add(SaveData(it[i].image,it[i].name,it[i].number,it[i].position))
            }
            var adapter = Adapter(save)
            rvc.adapter = adapter
            rvc.layoutManager = LinearLayoutManager(context)
        })

    }

}