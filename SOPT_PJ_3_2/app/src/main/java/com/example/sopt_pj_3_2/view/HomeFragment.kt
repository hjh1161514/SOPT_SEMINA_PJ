package com.example.sopt_pj_3_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

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
        rv_home.adapter = instaAdapter
        rv_home.addItemDecoration(IDecoration())
        loadDatas()
    }

    private fun loadDatas(){
        datas.apply {
            add(
                InstaData(
                userName = "A",
                img_profile ="https://cdn.pixabay.com/photo/2020/05/03/13/09/puppy-5124947_1280.jpg",
                img_contents="https://cdn.pixabay.com/photo/2020/05/19/20/54/waffles-5192625__480.jpg"
                ))
            add(
                InstaData(
                    userName = "B",
                    img_profile ="https://cdn.pixabay.com/photo/2020/05/03/13/09/puppy-5124947_1280.jpg",
                    img_contents="https://cdn.pixabay.com/photo/2020/05/17/07/55/cat-5180495__480.jpg"
                ))
            add(
                InstaData(
                    userName = "C",
                    img_profile ="https://cdn.pixabay.com/photo/2020/05/03/13/09/puppy-5124947_1280.jpg",
                    img_contents="https://cdn.pixabay.com/photo/2020/05/17/07/55/cat-5180496__480.jpg"
                ))
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }
}

