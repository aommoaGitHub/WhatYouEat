package com.example.vittunyutamaeprasart.whatyoueat.presenter

import com.example.vittunyutamaeprasart.whatyoueat.models.Dish
import com.example.vittunyutamaeprasart.whatyoueat.models.DishRepositoryMock
import com.example.vittunyutamaeprasart.whatyoueat.models.Store
import com.example.vittunyutamaeprasart.whatyoueat.models.StoreRepositoryMock

/**
 * Created by vittunyutamaeprasart on 22/5/2018 AD.
 */
class StorePresenter(val view: StoreView){

    fun start(){
        view.setStoresList(StoreRepositoryMock.instance.serarchSuitableStores())
    }

}