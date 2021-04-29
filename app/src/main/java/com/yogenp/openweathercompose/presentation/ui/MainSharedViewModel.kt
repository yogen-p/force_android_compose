package com.yogenp.openweathercompose.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogenp.openweathercompose.network.model.ForceInfoDTO
import com.yogenp.openweathercompose.network.model.ForceListDTO
import com.yogenp.openweathercompose.repository.ForceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainSharedViewModel
@Inject
constructor(
    private val repository: ForceRepository
) : ViewModel() {

    val forces: MutableState<List<ForceListDTO>> = mutableStateOf(listOf())
    val forceInfo: MutableState<ForceInfoDTO?> = mutableStateOf(null)
    val loading = mutableStateOf(false)

    init {
        newSearch()
    }

    fun newSearch() {
        viewModelScope.launch {
            loading.value = true

            forces.value = repository.getForceList()

            loading.value = false
        }
    }

    fun selectForce(forceId: String) {
        viewModelScope.launch {
            loading.value = true

            forceInfo.value = repository.getForceInfo(forceId)

            loading.value = false
        }
    }

}