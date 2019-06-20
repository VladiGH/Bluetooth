package com.avgh.bluetoothmessaging.database.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.avgh.bluetoothmessaging.database.daos.MessageDao
import com.avgh.bluetoothmessaging.database.daos.ProfileDao
import com.avgh.bluetoothmessaging.database.entities.Message
import com.avgh.bluetoothmessaging.database.entities.Profile


class ChatRepository(private val profileDao: ProfileDao, private val messageDao: MessageDao) {

    val allprofiles: LiveData<List<Profile>> = profileDao.getAllProfile()
    val allmessage: LiveData<List<Message>> = messageDao.getAllMessage()



    @WorkerThread
    suspend fun insert(profile: Profile) {
        profileDao.InsertProfile(profile)
    }

    @WorkerThread
    suspend fun insert(message: Message) {
       messageDao.InsertMessage(message)
    }


    @WorkerThread
    fun FindProfile(IdProfile: Int) {
        profileDao.getProfile(IdProfile)
    }


}