package br.com.emanuel.desafiomarvelhqs.comicdetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import br.com.emanuel.desafiomarvelhqs.comicdetail.repository.ComicDetailRepository
import kotlinx.coroutines.Dispatchers

@Suppress("UNCHECKED_CAST")
class ComicDetailViewModel(
    private val repository: ComicDetailRepository
): ViewModel() {


    fun getComicById(id: Int) = liveData(Dispatchers.IO) {
        val response = repository.getComicById(id)
        emit(response.data.results)
    }

    class ComicViewModelFactory(
        private val repository: ComicDetailRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicDetailViewModel(
                repository
            ) as T
        }
    }
}