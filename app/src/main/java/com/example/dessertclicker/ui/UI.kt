package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.data.DessertUIData
import com.example.dessertclicker.determineDessertToShow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UI : ViewModel() {
    private var dud: MutableStateFlow<DessertUIData> =MutableStateFlow(DessertUIData());
    var uiState: MutableStateFlow<DessertUIData> = dud;
    
    fun onDessertClicked() {
        uiState.update{currentState:DessertUIData->
            currentState.copy(
                revenue=currentState.revenue+currentState.currentDessertPrice,
                dessertsSold=currentState.dessertsSold++,
                currentDessertIndex=(currentState.currentDessertIndex+1)%Datasource.dessertList.size,
                currentDessertPrice=Datasource.dessertList[(currentState.currentDessertIndex+1)%Datasource.dessertList.size].imageId,
                currentDessertImageId= Datasource.dessertList[(currentState.currentDessertIndex+1)%Datasource.dessertList.size].imageId
            )
        }
    }
}