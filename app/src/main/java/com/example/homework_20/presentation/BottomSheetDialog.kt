package com.example.homework_20.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_20.R
import com.example.homework_20.data.BottomSheetData
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_layout.*

class BottomSheetDialog(private val listener: (BottomSheetData) -> Unit) :
    BottomSheetDialogFragment() {

    private val bottomSheetAdapter by lazy { BottomSheetAdapter() }
    private val viewModel by lazy { BottomSheetViewModel() }

    companion object {
        fun newInstance(listener: (BottomSheetData) -> Unit) = BottomSheetDialog(listener)
        const val TAG = "3"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserves()
        initRecycler()
    }

    override fun getTheme() = R.style.AppBottomSheetDialogTheme

    private fun initRecycler() {
        recyclerBottom.adapter = bottomSheetAdapter
        bottomSheetAdapter.setItemOnclickListener { bottomSheetData ->
            listener.invoke(bottomSheetData)
            dismiss()
        }
    }

    private fun initObserves() {
        viewModel.bottomSheetNewData.observe(viewLifecycleOwner) { bottomSheetNewData ->
            bottomSheetAdapter.submitList(bottomSheetNewData)
        }
    }
}