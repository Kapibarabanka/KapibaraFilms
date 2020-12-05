package ua.kpi.comsys.iv7110.kapibarafilms.ui.movies

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.pop_up_add_movie.*
import ua.kpi.comsys.iv7110.kapibarafilms.R
import ua.kpi.comsys.iv7110.kapibarafilms.ui.allMovies

class AddMoviePopUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pop_up_add_movie)

        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width: Int = (dm.widthPixels)
        val height: Int = (dm.heightPixels)

        window.setLayout(width, height)
    }

    fun onSaveClicked(view: View) {
        val title = titleText.text.toString()
        val type = typeText.text.toString()
        val year = yearText.text.toString()
        val newMovie = Movie(title, year, "", type, "")
        allMovies.add(newMovie)
        finish()
    }
}
