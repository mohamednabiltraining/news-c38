package com.route.newsappc38sat.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.newsappc38sat.R
import com.route.newsappc38sat.databinding.ActivityHomeBinding
import com.route.newsappc38sat.ui.home.news.NewsFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, NewsFragment())
            .commit()

    }
}