package com.example.seguimientosiniestros.data.repository

import android.content.Context
import com.example.seguimientosiniestros.data.local.AppDatabase
import com.example.seguimientosiniestros.data.local.LocalSiniestroDataSource
import com.example.seguimientosiniestros.data.remote.RemoteSiniestroDataSource
import com.example.seguimientosiniestros.data.remote.RetrofitProvider
import com.example.seguimientosiniestros.domain.repository.SiniestroRepository

object RepositoryProvider {

    fun provideSiniestroRepository(context: Context): SiniestroRepository {
        val database = AppDatabase.getInstance(context)

        val localDataSource = LocalSiniestroDataSource(
            siniestroDao = database.siniestroDao(),
            gestionHistorialDao = database.gestionHistorialDao()
        )

        val remoteDataSource = RemoteSiniestroDataSource(
            apiService = RetrofitProvider.crearSiniestroApi()
        )

        return RemoteFirstSiniestroRepository(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
    }
}
