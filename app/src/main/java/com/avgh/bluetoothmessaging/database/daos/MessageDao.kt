package com.avgh.bluetoothmessaging.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.avgh.bluetoothmessaging.database.entities.Message


@Dao
interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertMessage(message: Message)

    @Query("SELECT * FROM message_table")
    fun getAllMessage(): LiveData<List<Message>>

}