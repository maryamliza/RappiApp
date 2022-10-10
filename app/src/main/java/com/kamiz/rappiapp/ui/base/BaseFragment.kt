package com.kamiz.rappiapp.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupViews()
    }

    open fun setupViews() {}
    open fun setupObserver() {}
}