package com.example.week6day1.presenter

import com.example.week6day1.model.Repositories
import com.example.week6day1.network.GitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GitPresenter: GitContract.Presenter{

    private val gitFactory= GitFactory()
    private lateinit var view: GitContract.View

    override fun getRepsotories() {
        gitFactory.getRepsotories().enqueue(object: Callback<List<Repositories>>{


            override fun onFailure(call: Call<List<Repositories>>, t: Throwable) {

                view.displayError()


            }

            override fun onResponse(call: Call<List<Repositories>>, response: Response<List<Repositories>>) {
                response.body()?.let { repositories ->
                    if (repositories.isNotEmpty()) {
                        view.displayRepsotories(repositories)


                    }
                    else
                        view.displayError()

                }


            }

        })
    }

    override fun setView(view: GitContract.View) {
        this.view = view
    }


}