package com.ironmeddie.test_task2.presentation.screens.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironmeddie.test_task2.common.utils.DataResource
import com.ironmeddie.test_task2.common.utils.log
import com.ironmeddie.test_task2.data.dto.ProductsDto
import com.ironmeddie.test_task2.domain.models.Products
import com.ironmeddie.test_task2.domain.use_cases.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val useCase: GetDataUseCase) : ViewModel() {

    private val _state: MutableStateFlow<DataResource<Products>> = MutableStateFlow(DataResource.Loading)
    val state = _state.asStateFlow()

    private val _search = MutableStateFlow("")
    val search = _search.asStateFlow()

    init {
        getData()
    }

    fun getData() {
        useCase().onEach {
            _state.value = it
            if (it is DataResource.Failure){
                log(it.otherMessage.toString())
                log(it.errorBody.toString())
                log(it.isNetworkError.toString())
            }
        }.launchIn(viewModelScope)
    }

    fun search(text: String) {
        _search.value = text
        //search query to api
    }

}


