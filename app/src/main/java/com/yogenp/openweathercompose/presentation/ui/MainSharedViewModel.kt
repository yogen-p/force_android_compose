package com.yogenp.openweathercompose.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogenp.openweathercompose.network.model.ForceInfoDTO
import com.yogenp.openweathercompose.network.model.ForceListDTO
import com.yogenp.openweathercompose.repository.ForceRepository
import com.yogenp.openweathercompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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

    var showToast = false
    var toastMessage = ""
    var selectedForce = ""

    init {
        newSearch()
    }

    fun newSearch() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = repository.getForceList()) {
                is Resource.Success -> forces.value = response.data!!
                is Resource.Error -> showError(response.message!!)
                else -> showError("An Unknown Error Occurred")
            }
        }
    }

    fun getForce() {
        viewModelScope.launch {
            when (val response = repository.getForceInfo(selectedForce)) {
                is Resource.Success -> forceInfo.value = response.data!!
                is Resource.Error -> showError(response.message!!)
                else -> showError("An Unknown Error Occurred")
            }
        }
    }

    private fun showError(message: String){
        toastMessage = message
        showToast = true
    }

    fun updateToast(){
        showToast = false
    }

    fun selectForce(forceId: String) {
        selectedForce = forceId
    }

    fun clear(){
        forceInfo.value = null
    }

}