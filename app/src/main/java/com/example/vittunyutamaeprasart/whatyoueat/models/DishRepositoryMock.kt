package com.example.vittunyutamaeprasart.whatyoueat.models

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import com.example.vittunyutamaeprasart.whatyoueat.RandomActivity
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by vittunyutamaeprasart on 22/5/2018 AD.
 */
class DishRepositoryMock{

    //    fun search(searchTitle: String, searchYear: String): ArrayList<Book> {
//        return ArrayList()
//    }
//
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
        alldisheslist = arrayListOf(Dish("Tuna Salad", allcategorieslist.get(3), allmeatlist.get(3), "tuna_salad.jpeg"),
                Dish("Fruit Salad", allcategorieslist.get(3), allmeatlist.get(4), "fruit_salad.jpg"),
                Dish("Chicken Salad", allcategorieslist.get(3), allmeatlist.get(1), "chicken_salad.jpg"),
                Dish("Caesar Salad", allcategorieslist.get(3), allmeatlist.get(0), "caesar_salad.jpeg"),
                Dish("Pork Burger",allcategorieslist.get(3),allmeatlist.get(0),"pork_burger.jpeg"))
    }

    private object Holder {
        val INSTANCE = DishRepositoryMock()
    }

    companion object {
        val instance: DishRepositoryMock by lazy { Holder.INSTANCE }
    }

    fun getAllDishes(): ArrayList<Dish> {
        return alldisheslist
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

//    private fun parseJson(){
//        val jsonObject = JSONObject(readFile())
//
//        val dish = getDishes(jsonObject.getJSONObject("dish"))
//    }
//
//    private fun getDishes(jsonObject: JSONObject) : Dish{
//        return Dish(
//                jsonObject.getString("name"),
//                jsonObject.getString("category"),
//                jsonObject.getString("meat"),
//                jsonObject.getString("photoname")
//        )
//    }
//
//    private fun readFile() : String {
//        val assetManager = getAssets()
//        val ims = assetManager.open("helloworld.txt")
//    }

    fun updateSelectedList(categorylist: ArrayList<String>, meatlist: ArrayList<String>){

        selectedCategoryList.clear()
        selectedMeatList.clear()
        this.selectedCategoryList = categorylist
        this.selectedMeatList = meatlist

        filterDishes()
    }
}