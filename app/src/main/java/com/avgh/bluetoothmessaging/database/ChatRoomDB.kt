package com.avgh.bluetoothmessaging.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.avgh.bluetoothmessaging.database.daos.MessageDao
import com.avgh.bluetoothmessaging.database.daos.ProfileDao
import com.avgh.bluetoothmessaging.database.entities.Message
import com.avgh.bluetoothmessaging.database.entities.Profile


@Database(entities = [Profile::class, Message::class], version = 1, exportSchema = false)
public abstract class ChatRoomDB : RoomDatabase() {

    abstract fun profileDao(): ProfileDao
    abstract fun messageDao(): MessageDao

    companion object {

        @Volatile
        private var INSTANCE: ChatRoomDB? = null


        fun getInstance(
            context: Context
        ): ChatRoomDB {

            val temp = INSTANCE

            if (temp != null) return temp
            else synchronized(this) {
                val instance =
                    Room
                        .databaseBuilder(
                            context,
                            ChatRoomDB::class.java,
                            "Basket_Database"
                        )
                        .build()

                INSTANCE = instance

                return instance
            }

        }


    }
}