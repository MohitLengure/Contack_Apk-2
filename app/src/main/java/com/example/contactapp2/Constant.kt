package com.example.contactapp2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactapp2.database.dao.ContactDao
import com.example.contactapp2.database.tables.Contact

val DB_NAME = "contact_database"

@Database(entities = [Contact::class], version = 1, exportSchema = true)
abstract class ContactAppDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao


    }



