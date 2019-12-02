package com.example.week6day1.presenter

import com.example.week6day1.model.Repositories

interface GitContract{

    interface Presenter{

        fun getRepsotories()
        fun setView(view: GitContract.View)
    }

    interface View{

        fun displayRepsotories(repos: List<Repositories>)
        fun displayError()

    }

}