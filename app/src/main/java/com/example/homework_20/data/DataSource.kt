package com.example.homework_20.data

import com.example.homework_20.domain.BottomSheetDataInteractor

class DataSource : BottomSheetDataInteractor {
    val bottomSheetItems: List<BottomSheetData> = initBottomSheetList()

    private fun initBottomSheetList(): List<BottomSheetData> {
        val list = mutableListOf<BottomSheetData>()
        for (i in 47 until 52) {
            list.add(
                BottomSheetData(
                    smartphoneModel = "Samsung Galaxy A$i"
                )
            )
        }
        return list
    }

    override fun loadBottomSheetData(): List<BottomSheetData> {
        return bottomSheetItems
    }
}