package com.example.aws_auth

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify

class AwsAuthApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        try {
            // Spraudnis autentifikācijas kategorijai
            Amplify.addPlugin(AWSCognitoAuthPlugin())

            // Amplify inicializēšana
            Amplify.configure(applicationContext)
            Log.i("MyAmplifyApp", "Initialized Amplify")
        } catch (error: AmplifyException) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error)
        }
    }
}