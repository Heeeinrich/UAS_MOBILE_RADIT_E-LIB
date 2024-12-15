package com.example.uasmobileradite_lib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uasmobileradite_lib.adapter.BookAdapter
import com.example.uasmobileradite_lib.databinding.FragmentLibraryBinding
import com.example.uasmobileradite_lib.BookViewModel

class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!
    private val bookViewModel: BookViewModel by activityViewModels()
    private lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        // Observing books in the library
        bookViewModel.libraryBooks.observe(viewLifecycleOwner) { books ->
            bookAdapter.submitList(books)
        }
    }

    private fun setupRecyclerView() {
        bookAdapter = BookAdapter { selectedBook ->
            removeFromLibrary(selectedBook)
        }
        binding.rvLibraryBooks.apply {
            adapter = bookAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun removeFromLibrary(book: com.example.uasmobileradite_lib.Book) {
        bookViewModel.deleteBook(book)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
