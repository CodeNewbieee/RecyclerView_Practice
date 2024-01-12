package com.example.basicrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.basicrecyclerview.databinding.ListItemBinding
import com.example.basicrecyclerview.databinding.ListTiitleBinding

class LegendAdapter(val dataList : MutableList<LegendItem>) :RecyclerView.Adapter<ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_TITLE = 1
        private const val VIEW_TYPE_LEGEND = 2

    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            VIEW_TYPE_TITLE -> {
                TitleViewHolder(ListTiitleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
            else -> {
                LegendViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(val item = dataList[position]) {
            is LegendItem.MyTitle -> (holder as TitleViewHolder).bind(dataList[position] as LegendItem.MyTitle)
            is LegendItem.MyItem -> (holder as LegendViewHolder).bind(dataList[position] as LegendItem.MyItem)
        }

        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is LegendItem.MyTitle -> VIEW_TYPE_TITLE
            is LegendItem.MyItem -> VIEW_TYPE_LEGEND
        }
    }

    inner class TitleViewHolder(private val binding: ListTiitleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : LegendItem.MyTitle) {
            binding.tvTitle.setText(item.type)
        }
    }

    inner class LegendViewHolder(private  val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : LegendItem.MyItem) {
            with(binding) {
                ivItem.setImageResource(item.photo)
                tvName.setText(item.name)
                tvType.setText(item.type)
            }
        }
    }


}