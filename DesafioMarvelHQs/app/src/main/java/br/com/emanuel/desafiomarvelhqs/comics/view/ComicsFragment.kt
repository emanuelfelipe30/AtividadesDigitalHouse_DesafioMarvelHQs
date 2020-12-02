package br.com.emanuel.desafiomarvelhqs.comics.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.emanuel.desafiomarvelhqs.R
import br.com.emanuel.desafiomarvelhqs.comics.viewmodel.ComicViewModel
import br.com.emanuel.desafiomarvelhqs.comics.model.ComicModel
import br.com.emanuel.desafiomarvelhqs.comics.repository.ComicRepository

class ComicsFragment : Fragment() {

    private lateinit var myView: View
    private lateinit var myToolbar: Toolbar
    private lateinit var _viewModel: ComicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myView = view

        myToolbar = view.findViewById(R.id.myToolbar)
        activity?.setActionBar(myToolbar)
        activity?.actionBar?.setDisplayShowTitleEnabled(false)

        _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        _viewModel.getComics().observe(viewLifecycleOwner, Observer {
            createList(it)
        })

    }

    private fun createList(comics: List<ComicModel>) {
        val recyclerView = myView.findViewById<RecyclerView>(R.id.recyclerComics)
        val manager = GridLayoutManager(myView.context, 3)

        val boardsAdapter = ComicsAdapter(comics) {

        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = boardsAdapter
        }
    }


}