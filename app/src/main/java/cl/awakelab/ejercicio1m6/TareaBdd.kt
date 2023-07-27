package cl.awakelab.ejercicio1m6

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Tarea:: class], version = 1)
abstract class TareaBdd: RoomDatabase() {

        abstract fun getTareaDao(): TareaDao

        companion object {
            @Volatile
            private var INSTANCE: TareaBdd? = null

            fun getDatabase(context: Context): TareaBdd {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TareaBdd::class.java,
                        "TareaBdd"
                    ).build()

                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
