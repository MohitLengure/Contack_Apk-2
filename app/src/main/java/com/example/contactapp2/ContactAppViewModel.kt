package com.example.contactapp2


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.contactapp2.database.DBInstance


class ContactAppViewModel(var application: Application): AndroidViewModel(application) {
    fun test()
    {
        DBInstance.getInstance(application)
    }

}