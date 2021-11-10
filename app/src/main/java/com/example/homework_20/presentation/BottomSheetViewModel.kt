package com.example.homework_20.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework_20.data.BottomSheetData
import com.example.homework_20.data.DataSource
import com.example.homework_20.domain.BottomSheetDataInteractor

class BottomSheetViewModel : ViewModel() {
    private val interactor: BottomSheetDataInteractor = DataSource()

    val bottomSheetNewData: LiveData<List<BottomSheetData>> get() = _bottomSheetNewData
    private val _bottomSheetNewData =
        MutableLiveData<List<BottomSheetData>>(interactor.loadBottomSheetData())
}