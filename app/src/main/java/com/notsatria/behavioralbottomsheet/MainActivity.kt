package com.notsatria.behavioralbottomsheet

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>
    private lateinit var layoutBottomSheet: FrameLayout

    private val bottomSheetContentList = listOf(
        Pair("Nasi Padang", "Rp 30.000"),
        Pair("Ayam Bakar", "Rp 25.000"),
        Pair("Sate Ayam", "Rp 20.000"),
        Pair("Mie Ayam", "Rp 15.000"),
        Pair("Soto Ayam", "Rp 18.000"),
        Pair("Nasi Goreng", "Rp 22.000"),
        Pair("Capcay", "Rp 12.000"),
        Pair("Ikan Bakar", "Rp 35.000"),
        Pair("Gado-Gado", "Rp 28.000"),
        Pair("Rendang", "Rp 32.000")
    )

    private lateinit var contentAdapter: ContentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomSheet()
        setupRecyclerView()
        setupButton()
    }

    // Fungsi untuk mengatur tampilan Bottom Sheet
    private fun setupBottomSheet() {
        layoutBottomSheet = findViewById(R.id.layoutBottomSheet)
        bottomSheetBehavior = BottomSheetBehavior.from(layoutBottomSheet).apply {
            // Konfigurasi behavior sesuai kebutuhan (saat ini bottom sheet selalu hidden pada awal aplikasi dijalankan)
            isHideable = true
            state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    private fun setupRecyclerView() {
        val rvBottomSheetContent = findViewById<RecyclerView>(R.id.rvBottomSheetContent)
        contentAdapter = ContentAdapter()
        contentAdapter.setData(bottomSheetContentList)
        rvBottomSheetContent.adapter = contentAdapter
        rvBottomSheetContent.layoutManager = LinearLayoutManager(this)
    }

    private fun setupButton() {
        val btnShowBottomSheet = findViewById<Button>(R.id.btnShowBottomSheet)
        btnShowBottomSheet.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}