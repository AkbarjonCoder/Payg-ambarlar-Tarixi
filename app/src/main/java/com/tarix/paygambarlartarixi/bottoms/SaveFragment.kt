package com.tarix.paygambarlartarixi.bottoms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tarix.paygambarlartarixi.adapter.Adapter
import com.tarix.paygambarlartarixi.database.LiveModel
import com.tarix.paygambarlartarixi.database.SaveData
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.tarix.paygambarlartarixi.room.ViewModel
import uz.tarix.paygambarlartarixi.R

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
        var save = ArrayList<SaveData>()
        var adapter = Adapter(save)

        viewModel.getData.observe(requireActivity(), Observer {

            if (it.isNotEmpty()){
                for (i in it.indices){
                    save.add(SaveData(it[i].image,it[i].name,it[i].number,it[i].position))
                }
                adapter = Adapter(save)
                rvc.adapter = adapter
                rvc.layoutManager = LinearLayoutManager(context)
            }

        })

        val model= LiveModel()

//        model.sending().observer.observe(requireActivity(), Observer {
//            viewModel.delete(it)
//            Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show()
//        })



    }

}