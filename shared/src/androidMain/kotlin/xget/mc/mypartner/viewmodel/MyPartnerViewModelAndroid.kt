package xget.mc.mypartner.viewmodel

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import xget.mc.mypartner.db.LocalDb
import xget.mc.mypartner.repositories.GptRepository

fun MyParterViewModel.Factory.getAndroidInstance(context : Context) : MyParterViewModel {
    val sqlDriver = AndroidSqliteDriver(LocalDb.Schema, context, "Local.db")
    val repository = GptRepository(sqlDriver = sqlDriver)
    return MyParterViewModel(repository)
}