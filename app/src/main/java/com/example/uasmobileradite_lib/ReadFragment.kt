package com.example.uasmobileradite_lib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uasmobileradite_lib.databinding.FragmentReadBinding

class ReadFragment : Fragment() {

    private var _binding: FragmentReadBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example: Displaying a book's content
        binding.tvBookTitle.text = "Sample Book Title"
        binding.tvContent.text = "This is the content of the book. It is displayed in the ReadFragment."
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
