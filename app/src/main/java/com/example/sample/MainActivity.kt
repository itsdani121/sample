package com.example.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mBottomSheetBehavior: BottomSheetBehavior<View?>? = null
    private var isClick = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureBackdrop()

    }

    private fun configureBackdrop() {
        // Get the fragment reference
        val fragment = supportFragmentManager.findFragmentById(R.id.filter_fragment)

        fragment?.let {
            // Get the BottomSheetBehavior from the fragment view
            BottomSheetBehavior.from(it.requireView()).let { bsb ->
                // Set the initial state of the BottomSheetBehavior to HIDDEN
                bsb.state = BottomSheetBehavior.STATE_HIDDEN

                // Set the trigger that will expand your view
                fab_filter.setOnClickListener {
                    if (isClick) {
                        bsb.state = BottomSheetBehavior.STATE_EXPANDED
                        isClick = false;
                    } else {
                        bsb.state = BottomSheetBehavior.STATE_HIDDEN
                        isClick = true;
                    }
                    // Set the reference into class attribute (will be used latter)
                    mBottomSheetBehavior = bsb
                }
            }
        }
    }

    override fun onBackPressed() {
        // With the reference of the BottomSheetBehavior stored
        mBottomSheetBehavior?.let {
            if (it.state == BottomSheetBehavior.STATE_EXPANDED) {
                it.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                super.onBackPressed()
            }
        } ?: super.onBackPressed()
    }

}