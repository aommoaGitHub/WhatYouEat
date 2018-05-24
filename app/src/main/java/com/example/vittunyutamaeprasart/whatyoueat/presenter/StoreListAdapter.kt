package com.example.vittunyutamaeprasart.whatyoueat.presenter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.vittunyutamaeprasart.whatyoueat.R
import com.example.vittunyutamaeprasart.whatyoueat.models.Store

class StoreListAdapter(context: Context,storeList: ArrayList<Store>): BaseAdapter() {

    var context : Context = context
    var storeList: ArrayList<Store> = storeList

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.store_list, null)
        val storeName: TextView = view.findViewById(R.id.storename)
        val storeType: TextView = view.findViewById(R.id.storetype)
        val storePrice: TextView = view.findViewById(R.id.storeprice)
        val storeAddress: TextView = view.findViewById(R.id.storeaddress)
        val storeReview: TextView = view.findViewById(R.id.storereview)
        // set text for each textview
        val currentStore = storeList[position]
        storeName.text = currentStore.name
        storeType.text = "Type:" + currentStore.type
        storePrice.text = "Period Price:" + currentStore.periodprice
        storeAddress.text = "Address:" + currentStore.address
        storeReview.text = "Review:" + currentStore.review
        return view
    }

    override fun getItem(position: Int): Any {
        return storeList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return storeList.size
    }

}