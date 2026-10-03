package com.example.seguimientosiniestros.data.repository

import android.content.Context
import com.example.seguimientosiniestros.data.local.AppDatabase
import com.example.seguimientosiniestros.data.local.LocalSiniestroDataSource
import com.example.seguimientosiniestros.domain.repository.SiniestroRepository

object RepositoryProvider {

    fun provideSiniestroRepository(context: Context): SiniestroRepository {
        val database = AppDatabase.getInstance(context)

        return LocalSiniestroRepository(
            localDataSource = LocalSiniestroDataSource(
                siniestroDao = database.siniestroDao(),
                gestionHistorialDao = database.gestionHistorialDao()
            )
        )
    }
}
