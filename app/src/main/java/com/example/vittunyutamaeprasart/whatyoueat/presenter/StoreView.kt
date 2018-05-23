package com.example.vittunyutamaeprasart.whatyoueat.presenter

import com.example.vittunyutamaeprasart.whatyoueat.models.Store

/**
 * Created by vittunyutamaeprasart on 22/5/2018 AD.
 */
interface StoreView {
    fun setStoresList(stores: ArrayList<Store>)
}