package xget.mc.mypartner.viewmodel

import com.squareup.sqldelight.db.Closeable
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import xget.mc.mypartner.db.LocalDb
import xget.mc.mypartner.repositories.GptRepository
import xget.mc.mypartner.viewmodel.states.AppState

fun MyParterViewModel.Factory.getIosInstance() : MyParterViewModel {
    val sqlDriver = NativeSqliteDriver(LocalDb.Schema, "Local.db")
    val repository = GptRepository(sqlDriver = sqlDriver)
    return MyParterViewModel(repository)
}

// this is required, because default arguments of Kotlin functions are currently not exposed to Objective-C or Swift
// https://youtrack.jetbrains.com/issue/KT-41908
fun MyParterViewModel.getDefaultAppState() : AppState {
    return AppState()
}

// this function notifies of any state changes to the iOS AppObservableObject class
// hopefully this code will eventually be provided by an official Kotlin function
// https://youtrack.jetbrains.com/issue/KT-41953
fun MyParterViewModel.onChange(provideNewState: ((AppState) -> Unit)) : Closeable {

    val job = Job()

    stateFlow.onEach {
        provideNewState(it)
    }.launchIn(
        CoroutineScope(Dispatchers.Main + job)
    )

    return object : Closeable {
        override fun close() {
            job.cancel()
        }
    }

}