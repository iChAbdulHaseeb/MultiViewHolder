package com.ichabdulhaseeb.sample.multiviewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ichabdulhaseeb.sample.multiviewholder.databinding.Box1LayoutBinding
import com.ichabdulhaseeb.sample.multiviewholder.databinding.Box2LayoutBinding

class MyAdapter(private val mList: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            0 -> {
                val itemBinding =
                    Box1LayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderBox1(itemBinding)
            }
            else -> {
                val itemBinding =
                    Box2LayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderBox2(itemBinding)
            }
        }
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = mList[position]

        when(holder.itemViewType){
            0 -> {
                val viewHolderBox1 : ViewHolderBox1 = holder as ViewHolderBox1
                viewHolderBox1.bind(item)
            }

            1 -> {
                val viewHolderBox2 : ViewHolderBox2 = holder as ViewHolderBox2
                viewHolderBox2.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        // Just as an example, return 0 or 1 depending on position
        return position % 2
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views
    class ViewHolderBox1(private val itemBinding: Box1LayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.tv.text = title
        }
    }

    class ViewHolderBox2(private val itemBinding: Box2LayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.tv.text = title
        }
    }
}