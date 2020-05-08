package com.example.sopt_pj_2_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    val datas = mutableListOf<InstaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_home.adapter = instaAdapter //리사이클러뷰의 어댑터를 instaAdapter로 지정
        //rv_home.removeItemDecoration(IDecoration())
        rv_home.addItemDecoration(IDecoration())
        loadDatas() //데이터를 임의로 생성하고 어댑터에 전달
    }

    private fun loadDatas(){
        datas.apply {
            add(
                InstaData(
                userName = "정화진",
                img_profile ="https://cdn.pixabay.com/photo/2020/03/29/20/11/flowers-4982129__480.jpg",
                img_contents="https://cdn.pixabay.com/photo/2020/05/06/02/35/squirrel-5135848__480.jpg"
                ))
            add(
                InstaData(
                    userName = "정화진2",
                    img_profile ="https://cdn.pixabay.com/photo/2020/05/04/16/53/teddy-5129846__480.jpg",
                    img_contents="https://cdn.pixabay.com/photo/2020/05/04/06/54/plant-5128079__480.jpg"
                ))
            add(
                InstaData(
                    userName = "정화진3",
                    img_profile ="https://cdn.pixabay.com/photo/2020/05/06/17/58/children-5138536__480.png",
                    img_contents="https://cdn.pixabay.com/photo/2020/05/01/17/49/forest-5118367__480.jpg"
                ))
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }
}

