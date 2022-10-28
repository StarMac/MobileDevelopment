package com.example.homeproject2.ui.ui.tabbed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.homeproject2.databinding.FragmentTabbedBinding

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentTabbedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this)[PageViewModel::class.java].apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabbedBinding.inflate(inflater, container, false)
        val root = binding.root

        val textView: TextView = binding.sectionLabel
        val btnFirstActivity = binding.btnFirstActivity
        pageViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
            if (pageViewModel.index.value == 3) {
                btnFirstActivity.visibility = View.VISIBLE
            }
            else {
                btnFirstActivity.visibility = View.GONE
            }
        }
        btnFirstActivity.setOnClickListener{goToDrawerActivity()}
        return root
    }

    private fun goToDrawerActivity(){
        /* Немає сенсу використовувати інтент,
         тому що під час запуску інтенту ми не повертаємося на попердню активність,
         а створюємо її копію і вона відкривається поверх попередніх. */
//        val intent = Intent (activity, MainActivity::class.java)
//        activity!!.startActivity(intent)
        requireActivity().finish()
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}