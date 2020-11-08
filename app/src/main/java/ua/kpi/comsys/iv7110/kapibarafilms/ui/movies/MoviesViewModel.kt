package ua.kpi.comsys.iv7110.kapibarafilms.ui.movies

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import ua.kpi.comsys.iv7110.kapibarafilms.R
import java.io.*

const val TAG = "MyFilms_LOG"

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val _movies = MutableLiveData(importFromJSON(getApplication()))
    val movies: LiveData<List<Movie>> = _movies
}

fun importFromJSON(context: Context): List<Movie> {
    var streamReader: InputStreamReader? = null
    var fileInputStream: InputStream? = null
    try {
        fileInputStream = context.resources.openRawResource(R.raw.movies)
        streamReader = InputStreamReader(fileInputStream)
        val gson = Gson()
        val dataItems: DataItems = gson.fromJson(streamReader, DataItems::class.java)
        return dataItems.Search
    } catch (ex: IOException) {
        Log.e(TAG, ex.stackTrace.toString())
        ex.printStackTrace()
    } finally {
        if (streamReader != null) {
            try {
                streamReader.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    return listOf()
}

class DataItems {
    var Search: List<Movie> = listOf()
}