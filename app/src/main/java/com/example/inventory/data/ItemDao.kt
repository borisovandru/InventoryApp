package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //OnConflictStrategy.IGNORE игнорирует(не добаляет) новый элемент, если его первичный ключ уже находится в базе данных
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>> //рекомендуется использовать тип Flow вместо LiveData. Из-за типа возврата Flow Room выполняет запрос в фоновом потоке. Так же Room обновляет Flow сам без вашей помощи


}