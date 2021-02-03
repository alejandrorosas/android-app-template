package dev.alejandrorosas.featuretemplate.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.alejandrorosas.featuretemplate.di.FeatureTemplateModule.Constants.INITIAL_COUNTER
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class FeatureTemplateViewModel @Inject constructor(
    @Named(INITIAL_COUNTER) val initialCounter: Int
) : ViewModel() {
    private var _counter = MutableLiveData(initialCounter)
    val counter: LiveData<Int> = _counter

    fun onCounterClick() {
        _counter.postValue(_counter.value!! + 1)
    }
}
