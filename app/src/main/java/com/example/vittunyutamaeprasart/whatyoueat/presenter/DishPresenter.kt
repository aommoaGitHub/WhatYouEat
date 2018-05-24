package com.example.vittunyutamaeprasart.whatyoueat.presenter

import com.example.vittunyutamaeprasart.whatyoueat.models.Dish
import com.example.vittunyutamaeprasart.whatyoueat.models.DishRepositoryMock
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by vittunyutamaeprasart on 22/5/2018 AD.
 */
class DishPresenter (val view: DishView){

    var disheslist: ArrayList<Dish> = ArrayList()

    fun start(){
        this.disheslist = DishRepositoryMock.instance.getFilterDishes()
        view.updateChoices()
    }

    fun randomDishes(): ArrayList<Dish> {
        Collections.shuffle(disheslist)
        if (disheslist.size >= 4)
            return arrayListOf(disheslist.get(0),disheslist.get(1),disheslist.get(2),disheslist.get(3))
        return disheslist
    }

}