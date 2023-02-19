package com.tarix.paygambarlartarixi.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tarix.paygambarlartarixi.MediaActivity
import com.tarix.paygambarlartarixi.database.SaveData
import uz.tarix.paygambarlartarixi.R

class Adapter2(private val dataList: List<SaveData>): RecyclerView.Adapter<Adapter2.ViewHolderClass>(){

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

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        val currentItem = dataList[position]
            holder.image.setImageResource(currentItem.image)
            holder.title.text = currentItem.title
            holder.number.text = currentItem.number

            val cont = holder.cardView.context
            holder.cardView.setOnClickListener {
                val intent = Intent(it.context, MediaActivity::class.java)
                intent.putExtra("position","$position")

                it.context.startActivity(intent)

                Toast.makeText(cont, "the item ${currentItem.title} is clicked", Toast.LENGTH_SHORT).show()
            }


            holder.cardView.setOnLongClickListener(View.OnLongClickListener {
                Toast.makeText(cont, "the item ${currentItem.title} is long clicked", Toast.LENGTH_SHORT).show()

                return@OnLongClickListener true
            })


            holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.cardView.context, R.anim.scale_up))

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}