package com.ucb.examendispositivosm.subscription

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.domain.Plans
import com.ucb.usecases.GetPlans

@HiltViewModel
class SubscriptionViewModel @Inject constructor(
    private val getPlans: GetPlans
) : ViewModel() {

    private val plans_ = MutableStateFlow<List<Plans>>(emptyList())
    val plans: StateFlow<List<Plans>> = plans_
    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex

    fun previousPlan() {
        if (_currentIndex.value > 0) {
            _currentIndex.value -= 1
        }
    }
    fun nextPlan() {
        if (_currentIndex.value < plans_.value.size - 1) {
            _currentIndex.value += 1
        }
    }
    fun loadPlans() {
        viewModelScope.launch {
            plans_.value = getPlans.invoke()
        }
    }
}
