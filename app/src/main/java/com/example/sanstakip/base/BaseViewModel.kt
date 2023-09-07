package com.example.sanstakip.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<S : BaseEvents> : ViewModel() {

    private val _event = MutableLiveData<Event<S>>()
    val event: MutableLiveData<Event<S>>
        get() = _event

}