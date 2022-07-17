package com.neppplus.todolist_recyclerview_20220717

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.neppplus.todolist_recyclerview_20220717.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mPagerAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPagerAdapter = MainViewPagerAdapter(this)
        mainViewPager.adapter = mPagerAdapter

//        바텀 네비게이션 클릭 이벤트 처리
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> mainViewPager.currentItem = 0
                R.id.paper -> mainViewPager.currentItem = 1
                R.id.profile -> mainViewPager.currentItem = 2
            }
            return@setOnItemSelectedListener true
        }

//        뷰 페이저 연결
        mainViewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    bottomNav.menu.getItem(position).isChecked = true
                }
            }
        )
    }
}
