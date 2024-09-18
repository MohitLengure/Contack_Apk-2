package com.example.contactapp2.database

import android.content.Context
import androidx.room.Room
import com.example.contactapp2.ContactAppDatabase

 object DBInstance {
     private var dbInstance: ContactAppDatabase? = null

     fun getInstance(context: Context): ContactAppDatabase {
         synchronized(this) {
             if (dbInstance == null) {
                 dbInstance = Room.databaseBuilder(
                     context,
                     ContactAppDatabase::class.java,
                     "test"
                 ).build()

             }
             return dbInstance!!
         }


     }
 }