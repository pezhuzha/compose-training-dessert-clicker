package com.example.dessertclicker.data

import com.example.dessertclicker.model.Dessert

data class DessertUIData (

    var revenue: Int = 0,
    var dessertsSold: Int =0,

    var currentDessertIndex: Int =0,

    var currentDessertPrice: Int =Datasource.dessertList[currentDessertIndex].price,

    var currentDessertImageId: Int =Datasource.dessertList[currentDessertIndex].imageId
)
