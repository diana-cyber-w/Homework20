package com.example.homework_20.domain

import com.example.homework_20.data.BottomSheetData

interface BottomSheetDataInteractor {
    fun loadBottomSheetData(): List<BottomSheetData>
}