package com.example.my_smart_app

import android.annotation.SuppressLint
import android.app.Application
import android.widget.Toast
import com.thingclips.smart.home.sdk.ThingHomeSdk
import com.thingclips.smart.sdk.ThingSdk
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {

    private val channel = "initializeThingSDK"

    @SuppressLint("ShowToast")
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channel)
            .setMethodCallHandler { call: MethodCall, result: MethodChannel.Result ->
                when (call.method) {
                    "initSDK" -> {
                        ThingHomeSdk.init(application ,  "pn3w7e5ax9n7nq4dmygn" ,  "84e4v49eaa7x4vfahj5vkr5crpguj87w")
                        Toast.makeText(application , "SDK initiallized" , Toast.LENGTH_SHORT)
                        result.success("Initialized Successfully")
                    }
                    else -> {
                        result.notImplemented()
                    }
                }
            }
    }

}