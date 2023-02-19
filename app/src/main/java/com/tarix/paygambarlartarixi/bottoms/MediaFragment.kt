package com.tarix.paygambarlartarixi.bottoms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tarix.paygambarlartarixi.adapter.Adapter2
import com.tarix.paygambarlartarixi.database.SaveData
import uz.tarix.paygambarlartarixi.R

class MediaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<SaveData>
    lateinit var imageList: ArrayList<Int>
    lateinit var titleList: ArrayList<String>
    private lateinit var numberList: ArrayList<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        imageList = arrayListOf(
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz,
            R.drawable.islomuz
        )

        titleList = arrayListOf(
            "1 - Voqea",
            "2 - Voqea",
            "3 - Voqea",
            "4 - Voqea",
            "5 - Voqea",
            "6 - Voqea",
            "7 - Voqea",
            "8 - Voqea",
            "9 - Voqea",
            "10 - Voqea",
            "11 - Voqea",
            "12 - Voqea",
            "13 - Voqea",
            "14 - Voqea",
            "15 - Voqea",
            "16 - Voqea",
            "17 - Voqea",
            "18 - Voqea",
            "19 - Voqea",
            "20 - Voqea",
            "21 - Voqea",
            "22 - Voqea",
            "23 - Voqea",
            "24 - Voqea",
            "25 - Voqea",
            "26 - Voqea",
            "27 - Voqea",
            "28 - Voqea",
            "29 - Voqea",
            "30 - Voqea"
        )

        numberList = arrayListOf(
            "20:54",
            "18:47",
            "19:47",
            "19:45",
            "19:33",
            "18:57",
            "20:15",
            "19:19",
            "20:29",
            "19:08",
            "19:29",
            "19:07",
            "19:26",
            "19:43",
            "19:14",
            "19:40",
            "19:17",
            "19:23",
            "19:10",
            "19:10",
            "19:13",
            "20:10",
            "21:02",
            "20:27",
            "20:32",
            "20:01",
            "19:46",
            "19:51",
            "19:52",
            "21:38"
        )

        recyclerView = requireActivity().findViewById(R.id.rv2)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf()
        getData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media, container, false)
    }

    private fun getData() {
        for (i in 0 until numberList.size) {
            val dataClass = SaveData(imageList[i], titleList[i], numberList[i],i)
            dataList.add(dataClass)
        }
        recyclerView.adapter = Adapter2(dataList.toList())
    }

}