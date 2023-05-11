package xget.mc.mypartner.android

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import xget.mc.mypartner.viewmodel.MyParterViewModel
import xget.mc.mypartner.viewmodel.getAndroidInstance

class MyPartnerApp : Application() {

    lateinit var model: MyParterViewModel

    override fun onCreate() {
        super.onCreate()
        model = MyParterViewModel.Factory.getAndroidInstance(this)

        val appLifecycleObserver = AppLifecycleObserver(model)
        ProcessLifecycleOwner.get().lifecycle.addObserver(appLifecycleObserver)
    }

}

class AppLifecycleObserver (private val model: MyParterViewModel) : LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START ->
                if (model.stateFlow.value.recompositionIndex > 0) { // not calling at app startup
                    model.navigation.onReEnterForeground()
                }
            Lifecycle.Event.ON_STOP ->
                model.navigation.onEnterBackground()
            else ->
                return
        }
    }

}