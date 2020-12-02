package br.com.emanuel.desafiomarvelhqs.comicdetail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import br.com.emanuel.desafiomarvelhqs.R
import br.com.emanuel.desafiomarvelhqs.comicdetail.model.ComicDetailModel
import br.com.emanuel.desafiomarvelhqs.comicdetail.repository.ComicDetailRepository
import br.com.emanuel.desafiomarvelhqs.comicdetail.viewmodel.ComicDetailViewModel
import com.squareup.picasso.Picasso

class ComicDetailFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var _myView: View
    private lateinit var _viewModel: ComicDetailViewModel

    private lateinit var _imgArrowBackToComicsScreen: ImageView
    private lateinit var _imgComicDetail: ImageView
    private lateinit var _txtTitleComicDetail: TextView
    private lateinit var _txtDescriptionComicDetail: TextView
    private lateinit var _txtPublishedComicDetail: TextView
    private lateinit var _txtPriceComicDetail: TextView
    private lateinit var _txtPagesComicDetail: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comic_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        val id = requireArguments().let { ComicDetailFragmentArgs.fromBundle(it).comicId }

        _myView = view
        _viewModel = ViewModelProvider(
            this,
            ComicDetailViewModel.ComicViewModelFactory(ComicDetailRepository())
        ).get(ComicDetailViewModel::class.java)

        _viewModel.getComicById(id).observe(viewLifecycleOwner, Observer {
            initializeViews(it.first())
        })

    }

    private fun removeComicDetailScreenOfBackStack() {
        navController.popBackStack(R.id.comicDetailFragment, true)
    }

    private fun initializeViews(comic: ComicDetailModel) {

        _imgArrowBackToComicsScreen = _myView.findViewById(R.id.imgArrowBackToComicsScreen)
        _imgArrowBackToComicsScreen.setOnClickListener {
            removeComicDetailScreenOfBackStack()
        }

        val thumbnailUrl = "${comic.thumbnail.path}.${comic.thumbnail.extension}".replace("http://", "https://")
        _imgComicDetail = _myView.findViewById(R.id.imgComicDetail)
        Picasso.get().load(thumbnailUrl).into(_imgComicDetail)

        _txtTitleComicDetail = _myView.findViewById(R.id.txtTitleComicDetail)
        _txtTitleComicDetail.text = comic.title

        _txtDescriptionComicDetail = _myView.findViewById(R.id.txtDescriptionComicDetail)
        _txtDescriptionComicDetail.text = comic.description

        _txtPublishedComicDetail = _myView.findViewById(R.id.txtPublishedComicDetail)
        _txtPublishedComicDetail.text = comic.dates.firstOrNull()?.date

        _txtPriceComicDetail = _myView.findViewById(R.id.txtPriceComicDetail)
        _txtPriceComicDetail.text = getString(R.string.price_value, comic.prices.firstOrNull()?.price.toString())

        _txtPagesComicDetail = _myView.findViewById(R.id.txtPagesComicDetail)
        _txtPagesComicDetail.text = comic.pageCount.toString()

    }

}