package com.example.homework_20.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.homework_20.R
import com.example.homework_20.data.DataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val bottomSheetAdapter by lazy { BottomSheetAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        model.setOnClickListener {
            val bottomSheet = BottomSheetDialog.newInstance { bottomSheetData ->
                model.text = bottomSheetData.smartphoneModel.toEditable()
            }
            bottomSheet.show(supportFragmentManager, BottomSheetDialog.TAG)
        }
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}