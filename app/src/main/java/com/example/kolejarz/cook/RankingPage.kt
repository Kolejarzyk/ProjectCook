package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Class responsible for Ranking page's fragment.
 */
class RankingPage : Fragment() {

    /**
     * LayoutInflater is one of the Android System Services
     * that is responsible for taking your XML files that define a layout,
     * and converting them into View objects.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_ranking_page,null)
    }
}