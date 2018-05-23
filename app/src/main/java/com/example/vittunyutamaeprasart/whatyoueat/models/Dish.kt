package com.example.vittunyutamaeprasart.whatyoueat.models

/**
 * Created by vittunyutamaeprasart on 22/5/2018 AD.
 */
class Dish(val name: String,
           val category: String,
           val meat: String,
           val photoname: String) {

    override fun toString(): String {
        return "name:"+ name + " meat: "+ meat + " category: " + category + "\n"
    }

}