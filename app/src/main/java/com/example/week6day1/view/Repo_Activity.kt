package com.example.week6day1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6day1.R
import kotlinx.android.synthetic.main.activity_repo_.*

class Repo_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_)

        val gitLink = intent.getStringExtra("repositoryLink")

        Hubview.loadUrl(gitLink)

    }
}
