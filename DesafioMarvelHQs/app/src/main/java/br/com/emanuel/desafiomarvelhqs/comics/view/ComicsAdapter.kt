package br.com.emanuel.desafiomarvelhqs.comics.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.emanuel.desafiomarvelhqs.R
import br.com.emanuel.desafiomarvelhqs.comics.model.ComicModel

class ComicsAdapter(
    private var comics: List<ComicModel>,
    private val listener: (ComicModel) -> Unit
): RecyclerView.Adapter<ComicsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comics_list_item, parent, false)
        return ComicsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val item = comics[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount() = comics.size
}