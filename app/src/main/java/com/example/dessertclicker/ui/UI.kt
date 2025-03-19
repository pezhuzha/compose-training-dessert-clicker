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
    var uiState: StateFlow<DessertUIData> = dud.asStateFlow();
    
    fun onDessertClicked() {
        dud.update{currentState->
            var i:Int=currentState.currentDessertIndex
            if(Datasource.dessertList[(currentState.currentDessertIndex)].startProductionAmount<currentState.dessertsSold){
                i+=1}
            currentState.copy(
                revenue=currentState.revenue+currentState.currentDessertPrice,
                dessertsSold=currentState.dessertsSold+1,
                currentDessertIndex=i,
                currentDessertPrice=Datasource.dessertList[(currentState.currentDessertIndex)].price,
                currentDessertImageId= Datasource.dessertList[(currentState.currentDessertIndex)].imageId
            )
        }
    }
}