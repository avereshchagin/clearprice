package com.github.avereshchagin.clearprice.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    @StringRes
    open fun titleId(): Int = 0

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onStart() {
        super.onStart()

        if (titleId() != 0) {
            requireActivity().setTitle(titleId())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(), container, false)
    }
}