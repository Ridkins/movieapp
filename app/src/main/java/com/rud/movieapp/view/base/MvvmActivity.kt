package com.rud.movieapp.view.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

open class MvvmActivity<B : ViewDataBinding, V> :
    AppCompatActivity() where V : ViewModel, V : LifecycleObserver {
    @Inject
    lateinit var viewModelClass: Class<V>
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: B
    lateinit var viewModel: V

    public override fun onDestroy() {
        super.onDestroy()
    }

    protected fun setAndBindContentView(
        activity: AppCompatActivity,
        savedInstanceState: Bundle?, @LayoutRes layoutResID: Int
    ): View {
        setContentView(layoutResID)
        binding = DataBindingUtil.setContentView(this, layoutResID)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[viewModelClass]
        binding.setVariable(BR.vm, viewModel)
        activity.lifecycle.addObserver(viewModel)
        return binding.root
    }
}