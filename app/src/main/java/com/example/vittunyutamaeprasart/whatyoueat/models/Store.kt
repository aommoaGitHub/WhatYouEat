package com.example.vittunyutamaeprasart.whatyoueat.models

/**
 * Created by vittunyutamaeprasart on 22/5/2018 AD.
 */
class Store(val name: String,
            val type: String,
            val address: String,
            val review: String,
            val periodprice: Double,
            val menunamelist: ArrayList<String>) {

    override fun toString(): String {
        return "name:"+ name + "\ntype:"+ type + "\naddress:" + address + "\nperiodprice: " + periodprice + "\nreview:" + review +"\n"
    }
}