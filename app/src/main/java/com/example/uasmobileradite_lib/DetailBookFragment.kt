package com.example.uasmobileradite_lib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.uasmobileradite_lib.databinding.FragmentDetailBookBinding

// In the second Fragment (receiving data)
class DetailBookFragment : Fragment() {

    private var _binding: FragmentDetailBookBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString("title")
        val author = arguments?.getString("author")
        val year = arguments?.getInt("year")
        val synopsis = arguments?.getString("synopsis")
        val imageUrl = arguments?.getString("imageUrl")
        val content = arguments?.getString("content")

        // Create a Book object using the retrieved data
        val book = Book(
            title = title ?: "",
            author = author ?: "",
            year = year ?: 0,
            synopsis = synopsis ?: "",
            imageUrl = imageUrl ?: "",
            content = content ?: ""
        )

        displayBookDetails(book)
    }

    private fun displayBookDetails(book: Book) {
        binding.tvDetailTitle.text = book.title
        binding.tvDetailAuthor.text = book.author
        binding.tvDetailYear.text = book.year.toString()
        binding.tvDetailSynopsis.text = book.synopsis

        Glide.with(requireContext())
            .load(book.imageUrl.takeIf { !it.isNullOrEmpty() } ?: R.drawable.placeholder_image)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.error_image)
            .into(binding.ivBookCover)

        binding.btnReadBook.setOnClickListener {
            book.content?.let {
                val action = DetailBookFragmentDirections.actionDetailToRead(it)
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

