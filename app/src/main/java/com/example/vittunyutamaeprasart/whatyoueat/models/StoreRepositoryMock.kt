package com.example.vittunyutamaeprasart.whatyoueat.models

/**
 * Created by vittunyutamaeprasart on 22/5/2018 AD.
 */
class StoreRepositoryMock {

    private var currentDish: Dish = Dish("","","",0)
    private var priceMin: Double = 0.0
    private var priceMax: Double = 0.0
    private var allstores: ArrayList<Store> = ArrayList()

    private object Holder {
        val INSTANCE = StoreRepositoryMock()
    }

    companion object {
        val instance: StoreRepositoryMock by lazy { Holder.INSTANCE }
    }

    fun setPrice(priceMin: Double, priceMax: Double){
        this.priceMin = priceMin
        this.priceMax = priceMax
    }

    fun setAllStores(allstores: ArrayList<Store>){
        this.allstores = allstores
    }

    fun serarchSuitableStores() : ArrayList<Store>{
        if (allstores.size == 0)
            return ArrayList()

        if (currentDish.name == "")
            return allstores

        val suitableStore: ArrayList<Store> = ArrayList()
        for(store in allstores){
            if(store.periodprice >= priceMin && store.periodprice <= priceMax && store.menunamelist.contains(currentDish.name))
                suitableStore.add(store)
        }
        return suitableStore
    }

    fun setCurrentDish(currentDish: Dish){
        this.currentDish = currentDish
    }
}