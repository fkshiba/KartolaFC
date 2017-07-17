package com.example.vntfesh.kartolafc.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.vntfesh.kartolafc.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment();
    private val dashboardFragment = DashboardFragment();
    private val highlightFragment = HighlightFragment();

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
                return@OnNavigationItemSelectedListener true;
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, dashboardFragment).commit();
                return@OnNavigationItemSelectedListener true;
            }
            R.id.navigation_highlight -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, highlightFragment).commit();
                return@OnNavigationItemSelectedListener true;
            }
        }
        false;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, highlightFragment).commit();

//        RestApi().cartolaService.getStatus()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { status ->
//
//                }
    }
}
