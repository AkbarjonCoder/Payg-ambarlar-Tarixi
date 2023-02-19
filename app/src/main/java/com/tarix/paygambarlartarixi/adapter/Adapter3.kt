package com.tarix.paygambarlartarixi.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tarix.paygambarlartarixi.AudioActivity
import com.tarix.paygambarlartarixi.database.SaveData
import uz.tarix.paygambarlartarixi.R

class Adapter3(private val dataList: List<SaveData>): RecyclerView.Adapter<Adapter3.ViewHolderClass>(){

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageBook)
        val title: TextView = itemView.findViewById(R.id.title1)
        val number: TextView = itemView.findViewById(R.id.title2)
        val cardView : CardView = itemView.findViewById(R.id.cardView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        val currentItem = dataList[position]
        holder.image.setImageResource(currentItem.image)
        holder.title.text = currentItem.title
        holder.number.text = currentItem.number

        val cont = holder.cardView.context
        holder.cardView.setOnClickListener {
            val intent = Intent(it.context, AudioActivity::class.java)

            intent.putExtra("image", currentItem.image)
            intent.putExtra("title", currentItem.title)
            intent.putExtra("number", currentItem.number)
            intent.putExtra("position", "${dataList[position].position}")

            it.context.startActivity(intent)

        }
        holder.cardView.startAnimation(
            AnimationUtils.loadAnimation(
                holder.cardView.context,
                R.anim.scale_up
            )
        )
//        if (dataList[position].visible){
//
//        }
//        else{
//            holder.cardView.visibility = View.GONE
//        }
//           holder.cardView.setOnLongClickListener {
//               //.(holder.itemView.context,"${dataList[position].title}","${dataList[position].number}",position,false)
//               true
//           }
//
//    }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

