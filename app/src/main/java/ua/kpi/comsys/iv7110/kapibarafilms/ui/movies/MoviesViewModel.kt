package ua.kpi.comsys.iv7110.kapibarafilms.ui.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ua.kpi.comsys.iv7110.kapibarafilms.R
import ua.kpi.comsys.iv7110.kapibarafilms.ui.DataItems
import ua.kpi.comsys.iv7110.kapibarafilms.ui.importFromJSON

const val TAG = "KapibaraFilms_LOG"

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val _movies = MutableLiveData(importFromJSON(getApplication(), DataItems::class.java, R.raw.movies)?.Search ?: listOf())
    val movies: LiveData<List<Movie>> =_movies

    fun add()
    {

    }

}

