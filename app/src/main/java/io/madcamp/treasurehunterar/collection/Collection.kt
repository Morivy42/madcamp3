package io.madcamp.treasurehunterar.collection

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.random.Random


@Serializable
data class Collection(
    @SerialName("collection_id")
    val collectionNum: Int = 0,
    @SerialName("collection_name")
    val name: String = "???",
    @SerialName("short_description")
    val shortDescription: String = "?????",
    @SerialName("long_description")
    val longDescription: String = "????? ????? ?????",
    @SerialName("imageUrl")
    val imageUrl: String = "https://static.turbosquid.com/Preview/001290/167/LA/_D.jpg",
    val isFound: Boolean = Random.nextBoolean(),
)

@Serializable
data class CollectionEntity(
    val collectionNum: Int = 0,
    val name: String = "",
    val shortDescription: String = "",
    val longDescription: String = "",
    val imageUrl: String = "",
    val isFound: Boolean = false,
)

data class CollectionAPIEntity(
    val collection_id: Int,
    val collection_name: String,
    val short_description: String,
    val long_description: String,
    val imageUrl: String,
)

fun CollectionAPIEntity.toCollection(): Collection {
    return Collection(
        collectionNum = collection_id,
        name = collection_name,
        short_description,
        long_description,
        imageUrl,
        isFound = false,
    )
}
//
//
///*
// * Copyright 2022 The Android Open Source Project
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     https://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.google.samples.apps.nowinandroid.core.database.model
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import com.google.samples.apps.nowinandroid.core.model.data.Topic
//
///**
// * Defines a topic a user may follow.
// * It has a many to many relationship with [NewsResourceEntity]
// */
//@Entity(
//    tableName = "topics",
//)
//data class TopicEntity(
//    @PrimaryKey
//    val collectionNum: String,
//    val name: String,
//    val shortDescription: String,
//    @ColumnInfo(defaultValue = "")
//    val longDescription: String,
//    @ColumnInfo(defaultValue = "")
//    val url: String,
//    @ColumnInfo(defaultValue = "")
//    val imageUrl: String,
//)
//
//fun TopicEntity.asExternalModel() = Topic(
//    collectionNum = collectionNum,
//    name = name,
//    shortDescription = shortDescription,
//    longDescription = longDescription,
//    url = url,
//    imageUrl = imageUrl,
//)
