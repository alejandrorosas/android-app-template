package dev.alejandrorosas.featuretemplate.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeatureTemplateViewModel @ViewModelInject constructor(
//    val initialCounter: Int
) : ViewModel() {
    private var _counter = MutableLiveData(0)
    val counter: LiveData<Int> = _counter

    fun onCounterClick() {
        _counter.postValue(_counter.value!! + 1)
    }
}
