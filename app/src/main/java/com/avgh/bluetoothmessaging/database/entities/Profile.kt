package com.avgh.bluetoothmessaging.database.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "profile_table")
data class Profile (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "password") val password: String,
    @ForeignKey(entity = Message::class,parentColumns = ["id"],childColumns = ["message_id"])
    @ColumnInfo(name = "message_id") val message_id: Int

)