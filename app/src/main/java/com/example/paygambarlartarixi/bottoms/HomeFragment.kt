package com.example.paygambarlartarixi.bottoms

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paygambarlartarixi.AudioActivity
import com.example.paygambarlartarixi.R
import com.example.paygambarlartarixi.adapter.Adapter
import com.example.paygambarlartarixi.adapter.DataClass
import com.example.paygambarlartarixi.database.SaveData

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<SaveData>
    lateinit var imageList: ArrayList<Int>
    lateinit var titleList: ArrayList<String>
    private lateinit var numberList: ArrayList<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        imageList = arrayListOf(
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
            R.drawable.islam,
        )

        titleList = arrayListOf(
            "Odam A.S",
            "Idris A.S",
            "Nuh A.S",
            "Hud A.S",
            "Solih A.S",
            "Ibrohim A.S",
            "Lut A.S",
            "Ismoil A.S",
            "Isxoq A.S",
            "Yaqub A.S",
            "Yusuf A.S",
            "Ayyub A.S",
            "Shuayb A.S",
            "Muso A.S",
            "Horun A.S",
            "Yunus A.S",
            "Dovud A.S",
            "Sulaymon A.S",
            "Ilyos A.S",
            "Alyasa A.S",
            "Zakariyo A.S",
            "Iso A.S",
            "Muhammad A.S",
        )

        numberList = arrayListOf(
            "18:19",
            "05:09",
            "19:43",
            "08:21",
            "12:10",
            "12:06",
            "07:31",
            "12:30",
            "03:24",
            "04:51",
            "15:11",
            "19:37",
            "09:04",
            "27:32",
            "08:21",
            "06:50",
            "08:18",
            "11:07",
            "09:12",
            "06:28",
            "08:22",
            "21:06",
            "23:59"
        )

        recyclerView = requireActivity().findViewById(R.id.rv1)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf()
        getData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun getData() {
        for (i in 0 until numberList.size) {
            val dataClass = SaveData(imageList[i], titleList[i], numberList[i],i)
            dataList.add(dataClass)
        }
        recyclerView.adapter = Adapter(dataList)
    }

}