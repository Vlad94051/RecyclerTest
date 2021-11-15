package ru.tms.recyclertest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_radio_group.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import ru.tms.recyclertest.R

class RadioGroupFragment(private val onChooseFilter: OnChooseFilter): Fragment() {

    companion object {
        const val TAG = "1324235235"
        fun newInstance(onChooseFilter: OnChooseFilter) = RadioGroupFragment(onChooseFilter)
    }

    private val filterViewModel : FilterSharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radio_group, container, false)
    }

    override fun onResume() {
        super.onResume()
        initRadioGroup()
    }

    private fun initRadioGroup(){
        group.setOnCheckedChangeListener { radioGroup, btnId ->
            when(btnId) {
                R.id.radio1 -> onChooseFilter.chooseFilter("Игры")
                R.id.radio2 -> onChooseFilter.chooseFilter("Foo")
                R.id.radio3 -> showToast(btnId.toString())
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}