package com.dimasridhoni.tesalodokter.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dimasridhoni.tesalodokter.R
import com.dimasridhoni.tesalodokter.model.FoodsData
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.content_carousel.*
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFoodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFoodFragment : Fragment() {
    // TODO: Rename and change types of parameters

    var name : String? =""
    companion object {
        var EXTRA_NAME = "extra_name"
    }


    /*internal var sampleImages =
        intArrayOf(R.drawable.nasi_goreng2, R.drawable.mie2, R.drawable.sate2, R.drawable.kue2, R.drawable.soto2)
    var imageListener: ImageListener =
        ImageListener { position, imageView -> imageView.setImageResource(sampleImages[position]) }
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (arguments != null) {
            name = arguments?.getString(EXTRA_NAME)
            println(name)

            var sampleImages = intArrayOf()
            println("Nama : $name")
            when (name) {
                "Nasi Goreng" -> {
                    sampleImages =  intArrayOf(R.drawable.nasi_goreng1, R.drawable.nasi_goreng2, R.drawable.nasi_goreng3)
                }
                "Soto" -> {
                    sampleImages =  intArrayOf(R.drawable.soto1, R.drawable.soto2, R.drawable.soto3)
                }
                "Sate" -> {
                    sampleImages =  intArrayOf(R.drawable.sate1, R.drawable.sate2, R.drawable.sate3)
                }
                "Mie" -> {
                    sampleImages =  intArrayOf(R.drawable.mie1, R.drawable.mie2, R.drawable.mie3)
                }
                "Kue" -> {
                    sampleImages =  intArrayOf(R.drawable.kue1, R.drawable.kue2, R.drawable.kue3)
                }
            }


            var imageListener: ImageListener =
                ImageListener { position, imageView -> imageView.setImageResource(sampleImages[position]) }

            carousel_view.setImageListener(imageListener)
            carousel_view.pageCount = sampleImages.size


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_detail_food, container, false)
    }


}