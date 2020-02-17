package com.rud.movieapp.view.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

public class MvvmActivity<B extends ViewDataBinding, V extends ViewModel & LifecycleObserver> extends AppCompatActivity {

    protected B binding;
    protected V viewModel;
    @Inject
    Class<V> viewModelClass;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected final View setAndBindContentView(@NonNull AppCompatActivity activity, @Nullable Bundle savedInstanceState, @LayoutRes int layoutResID) {
        setContentView(layoutResID);
        binding = DataBindingUtil.setContentView(this, layoutResID);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass);
        binding.setVariable(BR.vm, viewModel);
        activity.getLifecycle().addObserver(viewModel);
        return binding.getRoot();
    }
}
