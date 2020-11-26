package com.dimasridhoni.tesalodokter.model

import com.dimasridhoni.tesalodokter.R

object FoodsData {

    private val foodName = arrayOf(
        "Nasi Goreng",
        "Soto",
        "Sate",
        "Mie",
        "Kue"
        )

    private val foodImage = intArrayOf(
                    R.drawable.nasi_goreng1,
                    R.drawable.soto1,
                    R.drawable.sate1,
                    R.drawable.mie1,
                    R.drawable.kue1
                )



    val listData: ArrayList<Food>
        get() {
            val list = arrayListOf<Food>()
            for (position in foodName.indices) {
                val food = Food()
                food.name= foodName[position]
                food.image = foodImage[position]
                list.add(food)
            }
            return list
        }




}