package com.example.contactapp2.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.contactapp2.database.tables.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao
{

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contacts: List<Contact>)

    @Query("SELECT * FROM Contact_table")
    fun getContactsOrderedByName(): Flow<List<Contact>>



}