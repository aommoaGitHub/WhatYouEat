package com.example.vittunyutamaeprasart.whatyoueat.models

import com.example.vittunyutamaeprasart.whatyoueat.R
import kotlin.collections.ArrayList

/**
 * Created by vittunyutamaeprasart on 22/5/2018 AD.
 */
class DishRepositoryMock{

    private var alldisheslist:ArrayList<Dish>
    private val allcategorieslist: ArrayList<String>
    private val allmeatlist: ArrayList<String>
    private var selectedCategoryList: ArrayList<String>
    private var selectedMeatList: ArrayList<String>
    private var selectedDishesList: ArrayList<Dish> = ArrayList()

    init {
        selectedCategoryList = ArrayList()
        selectedMeatList = ArrayList()
        selectedDishesList = ArrayList()
        allcategorieslist = arrayListOf("steak","noodles","cookedByOrder","others")
        allmeatlist = arrayListOf("pork","chicken","beef","seafood","noMeat")
//        alldisheslist = arrayListOf(Dish("Tuna Salad", allcategorieslist.get(3), allmeatlist.get(3), R.drawable.tuna_salad),
//                Dish("Fruit Salad", allcategorieslist.get(3), allmeatlist.get(4), R.drawable.fruit_salad),
//                Dish("Chicken Salad", allcategorieslist.get(3), allmeatlist.get(1), R.drawable.chicken_satay_salad),
//                Dish("Caesar Salad", allcategorieslist.get(3), allmeatlist.get(0), R.drawable.caesar_salad),
//                Dish("Pork Burger",allcategorieslist.get(3),allmeatlist.get(0),R.drawable.pork_burger))
        alldisheslist = ArrayList()
    }

    private object Holder {
        val INSTANCE = DishRepositoryMock()
    }

    companion object {
        val instance: DishRepositoryMock by lazy { Holder.INSTANCE }
    }

    fun setAllDishes(inalllist: ArrayList<Dish>) {
        this.alldisheslist = inalllist
    }

    fun getFilterDishes(): ArrayList<Dish> {
        return selectedDishesList
    }

    fun filterDishes() {
        selectedDishesList.clear()

        if(selectedCategoryList.size == allcategorieslist.size && selectedMeatList.size == allmeatlist.size)
            selectedDishesList.addAll(alldisheslist)

        else {
            for (dish in alldisheslist){
                if(selectedCategoryList.contains(dish.category) && selectedMeatList.contains(dish.meat))
                    selectedDishesList.add(dish)
            }
        }
    }


    fun updateSelectedList(categorylist: ArrayList<String>, meatlist: ArrayList<String>){

        selectedCategoryList.clear()
        selectedMeatList.clear()
        this.selectedCategoryList = categorylist
        this.selectedMeatList = meatlist

        filterDishes()
    }




}