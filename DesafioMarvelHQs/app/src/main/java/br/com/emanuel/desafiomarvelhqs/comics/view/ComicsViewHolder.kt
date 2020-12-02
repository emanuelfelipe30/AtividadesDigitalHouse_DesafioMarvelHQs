package br.com.emanuel.desafiomarvelhqs.comics.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.emanuel.desafiomarvelhqs.R
import br.com.emanuel.desafiomarvelhqs.comics.model.ComicModel
import com.squareup.picasso.Picasso

class ComicsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val imgComicItem = view.findViewById<ImageView>(R.id.imgComicItem)
    private val txtComicItem = view.findViewById<TextView>(R.id.txtComicItem)

    fun bind(comic: ComicModel) {
        val thumbnailUrl = "${comic.thumbnail.path}.${comic.thumbnail.extension}".replace("http://", "https://")
        Picasso.get().load(thumbnailUrl).into(imgComicItem)
        txtComicItem.text = comic.title
    }
}