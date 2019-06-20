package com.avgh.bluetoothmessaging.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import androidx.lifecycle.viewModelScope
import com.avgh.bluetoothmessaging.database.ChatRoomDB
import com.avgh.bluetoothmessaging.database.entities.Message
import com.avgh.bluetoothmessaging.database.entities.Profile
import com.avgh.bluetoothmessaging.database.repository.ChatRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BasketViewModel (app: Application): AndroidViewModel(app){

    private val chatRepository: ChatRepository

    init {
        val profiledao= ChatRoomDB.getInstance(app).profileDao()
        val messageDao=ChatRoomDB.getInstance(app).messageDao()

     chatRepository = ChatRepository(profiledao,messageDao)
    }

    fun getAllProfile(): LiveData<List<Profile>> {
        return chatRepository.allprofiles

    }  fun getAllMessage(): LiveData<List<Message>> {
        return chatRepository.allmessage

    }
    fun insert(profile: Profile) = viewModelScope.launch(Dispatchers.IO){
        chatRepository.insert(profile)
    }fun insert(match: Message) = viewModelScope.launch(Dispatchers.IO){
        chatRepository.insert(match)
    }



}