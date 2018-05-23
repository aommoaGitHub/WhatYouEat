package com.example.vittunyutamaeprasart.whatyoueat.models

import com.example.vittunyutamaeprasart.whatyoueat.R

/**
 * Created by vittunyutamaeprasart on 22/5/2018 AD.
 */
class Dish(val name: String,
           val category: String,
           val meat: String,
           val photoID: Int) {

    override fun toString(): String {
        return "name:"+ name + " meat:"+ meat + " category:" + category + " photoid:" + photoID +"\n"
    }



}