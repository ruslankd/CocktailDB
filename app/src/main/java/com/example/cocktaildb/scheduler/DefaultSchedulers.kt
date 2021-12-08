package com.example.cocktaildb.scheduler

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

class DefaultSchedulers : Schedulers {
    override fun background() = io.reactivex.rxjava3.schedulers.Schedulers.newThread()

    override fun main() = AndroidSchedulers.mainThread()
}