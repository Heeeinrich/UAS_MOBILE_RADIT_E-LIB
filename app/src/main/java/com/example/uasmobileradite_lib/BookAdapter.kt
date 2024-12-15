package com.example.uasmobileradite_lib.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uasmobileradite_lib.R
import com.example.uasmobileradite_lib.databinding.ItemBookBinding
import com.example.uasmobileradite_lib.Book

class BookAdapter(private val onAddToLibrary: (Book) -> Unit) :
    ListAdapter<Book, BookAdapter.BookViewHolder>(BookDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position), onAddToLibrary)
    }

    class BookViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book, onAddToLibrary: (Book) -> Unit) {
            binding.tvTitle.text = book.title
            binding.tvAuthor.text = book.author

            // Load the image safely with Glide
            Glide.with(binding.root.context)
                .load(book.imageUrl ?: android.R.drawable.ic_menu_report_image)  // Built-in placeholder
                .placeholder(android.R.drawable.ic_menu_report_image)  // Built-in placeholder
                .into(binding.ivBookCover)


            binding.btnAddToLibrary.setOnClickListener {
                onAddToLibrary(book)
            }
        }
    }

    class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            // Check if the IDs are the same to identify unique items
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            // Compare all contents for efficient updates
            return oldItem == newItem
        }
    }
}
