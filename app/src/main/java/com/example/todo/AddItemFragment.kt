package com.example.todo

import android.app.LauncherActivity
import android.content.ClipData
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.FragmentAddItemBinding
import com.example.todo.databinding.FragmentTodoListBinding
import kotlin.properties.Delegates

class AddItemFragment : Fragment() {

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: ListViewModel by activityViewModels()

    private var pos: Int = -1
    private var content: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            pos = it.getInt("pos")
            content = it.getString("content").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.todoInput.setText(content)
        binding.addItem.setOnClickListener {
            if(pos >= 0) {
                val item = sharedViewModel.todo.value?.get(pos)
                if (item != null) {
                    item.content = binding.todoInput.text.toString()
                    sharedViewModel.updateItem(pos, item)
                }
            } else {
                sharedViewModel.addItem(ListItem(binding.todoInput.text.toString()))
            }
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}