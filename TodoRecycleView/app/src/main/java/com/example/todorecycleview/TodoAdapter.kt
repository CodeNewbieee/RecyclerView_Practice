package com.example.todorecycleview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todorecycleview.databinding.ItemTodoBinding

class TodoAdapter(private val todos:List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder { // 뷰를 만듦
        Log.d("RecyclerView", "onCreateViewHolder : $parent, $viewType")
        return TodoViewHolder(ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, //리사이클러뷰
            false ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) { // 그 뷰에 계속 정보를 담아 준다 , 스크롤 할 수록 자주 호출된다
        Log.d("RecyclerView", "onBindViewHolder : $position")
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size // 더 간결하게 작성 (return 없이)

    inner class TodoViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todo : Todo) {
            binding.tvTodoTitle.text = todo.title
            binding.todoCheck.isChecked = todo.completed
        }

    }


}