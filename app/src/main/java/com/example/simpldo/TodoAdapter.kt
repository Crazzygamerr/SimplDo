package com.example.simpldo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private var items: List<ListItem>,
    val onRemove: (Int) -> Unit,
    val onChecked: (Int, ListItem) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById<TextView>(R.id.todoContent)
        val checkbox: CheckBox = view.findViewById<CheckBox>(R.id.completeButton)
        val button: ImageView = view.findViewById<ImageView>(R.id.clearTodo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return TodoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.textView.text = items[position].content
        holder.checkbox.isChecked = items[position].isComplete
        holder.button.setOnClickListener { onRemove(position) }

        holder.checkbox.setOnCheckedChangeListener { _,b -> run{
            items[position].isComplete = b
            onChecked(position, items[position])
            }
        }

        holder.view.setOnClickListener {
            val action = TodoListFragmentDirections.actionTodoListFragmentToAddItemFragment(
                pos = position,
                content = items[position].content
            )
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}