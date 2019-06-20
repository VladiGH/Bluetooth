package com.avgh.bluetoothmessaging.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "message_table")
data class Message (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "enviado") val enviado: Int
    // @ForeignKey(entity = Match::class,parentColumns = ["id"],childColumns = ["match_id"])


)