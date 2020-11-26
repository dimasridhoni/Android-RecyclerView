package com.dimasridhoni.tesalodokter.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dimasridhoni.tesalodokter.R
import com.dimasridhoni.tesalodokter.adapter.ListFoodAdapter
import com.dimasridhoni.tesalodokter.fragment.DetailFoodFragment
import com.dimasridhoni.tesalodokter.model.Food
import com.dimasridhoni.tesalodokter.model.FoodsData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var rvFood: RecyclerView
    private var list: ArrayList<Food> = arrayListOf()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_food.setHasFixedSize(true)
        //setActionBarTitle(title)
        list.clear()
        list.addAll(FoodsData.listData)
        showRecyclerList()

    }

    private fun showRecyclerList() {
        rv_food.layoutManager = LinearLayoutManager(context)
        val listFoodAdapter = ListFoodAdapter(list)
        rv_food.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                val mDetailFragment = DetailFoodFragment()
                val mBundle = Bundle()
                mBundle.putString(DetailFoodFragment.EXTRA_NAME, data.name)
                mDetailFragment.arguments = mBundle
                val mFragmentManager = fragmentManager
                mFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.nav_host_fragment, mDetailFragment, DetailFoodFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()

                }

            }
        })
    }
}