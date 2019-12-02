package com.example.week6day1.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.week6day1.R
import com.example.week6day1.adaptor.RepoAdaptor
import com.example.week6day1.model.Repositories
import com.example.week6day1.presenter.GitContract
import com.example.week6day1.presenter.GitPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GitContract.View {


    lateinit var gitPresenter:GitPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Glide.with(this)
            .load(R.drawable.createcard)
            .into(card_background)

        gitPresenter = GitPresenter()
        gitPresenter.setView(this)
        gitPresenter.getRepsotories()

    }


    override fun displayRepsotories(repos: List<Repositories>){

        Glide.with(this)
            .load(repos[0].owner.avatarUrl)
            .into(card_image)

        card_title.text = repos[0].owner.login

        val repo = RepoAdaptor(repos)
        card_text.adapter = repo
        val linear = LinearLayoutManager(this)
        //linear.orientation = RecyclerView.HORIZONTAL
        card_text.layoutManager = linear
    }

    override fun displayError() {
        Toast.makeText(this, "Problems occured", Toast.LENGTH_SHORT).show()
    }
}
