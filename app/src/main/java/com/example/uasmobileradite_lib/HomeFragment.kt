package com.example.uasmobileradite_lib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uasmobileradite_lib.databinding.FragmentHomeBinding
import com.example.uasmobileradite_lib.adapter.BookAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val bookViewModel: BookViewModel by activityViewModels()
    private lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        // Observing the list of books from ViewModel
        bookViewModel.allBooks.observe(viewLifecycleOwner, Observer { books ->
            bookAdapter.submitList(books)
        })
    }

    private fun setupRecyclerView() {
        bookAdapter = BookAdapter { selectedBook ->
            addToLibrary(selectedBook)
        }
        binding.rvBooks.apply {
            adapter = bookAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun addToLibrary(book: Book) {
        bookViewModel.insertBook(book)
        Toast.makeText(requireContext(), "Added to Library", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
