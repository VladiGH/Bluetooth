package com.avgh.bluetoothmessaging.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.avgh.bluetoothmessaging.database.entities.Profile


@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertProfile(profile: Profile)

    @Query("SELECT * FROM profile_table")
    fun getAllProfile(): LiveData<List<Profile>>

    @Query("SELECT * FROM profile_table WHERE id = :id")
    fun getProfile(id: Int): LiveData<List<Profile>>


    @Query("SELECT * FROM profile_table WHERE username = :name")
    fun getProfile(name: String): LiveData<List<Profile>>

}