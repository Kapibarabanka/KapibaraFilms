package ua.kpi.comsys.iv7110.kapibarafilms.ui.charts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_charts.*
import ua.kpi.comsys.iv7110.kapibarafilms.R

class ChartsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_charts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        graphChip.setOnCheckedChangeListener { _, isChecked ->
            chart.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        diagramChip.setOnCheckedChangeListener { _, isChecked ->
            diagram.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
    }
}

