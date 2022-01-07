package com.example.simpldo

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpldo.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {

    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: ListViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.todoList
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TodoAdapter(sharedViewModel.todo.value!!, {
            i: Int ->
            run {
                sharedViewModel.removeItem(i)
                recyclerView.adapter!!.notifyItemRemoved(i)
            }
        }, {
            i:Int, item:ListItem ->
            sharedViewModel.todo.value!![i] = item
        })

        binding.addItem.setOnClickListener {
            val action = TodoListFragmentDirections.actionTodoListFragmentToAddItemFragment(content = "")
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}