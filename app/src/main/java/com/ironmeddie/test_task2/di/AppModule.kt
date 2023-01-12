package com.ironmeddie.test_task2.di

import android.content.Context
import android.content.pm.ApplicationInfo
import com.google.gson.GsonBuilder
import com.ironmeddie.test_task2.data.remote.ApiService
import com.ironmeddie.test_task2.data.remote.NetworkConnectionInterceptor
import com.ironmeddie.test_task2.data.repository.ProductsRepositoryImpl
import com.ironmeddie.test_task2.domain.repository.ProductsRepository
import com.ironmeddie.test_task2.common.utils.UtilConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    fun providesLoggingInterceptor(@ApplicationContext context: Context): HttpLoggingInterceptor {
        // check for debug or release
        return if (context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0) HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        else HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
    }

    @Provides
    fun providesNetworkConnectionInterceptor(@ApplicationContext context: Context): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(context)
    }

    @Provides
    fun providesOkHttpClient(logging: HttpLoggingInterceptor, networkConnectionInterceptor: NetworkConnectionInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(UtilConstants.TIME_OUT_CONNECTION, TimeUnit.SECONDS)
            .readTimeout(UtilConstants.TIME_OUT_CONNECTION, TimeUnit.SECONDS)
            .writeTimeout(UtilConstants.TIME_OUT_CONNECTION, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val url = chain
                    .request()
                    .url
                    .newBuilder()
                    .build()
                chain.proceed(chain.request().newBuilder().url(url).build())
            }
            .addInterceptor(logging)
            .addInterceptor(networkConnectionInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideProductsRepository(api: ApiService) : ProductsRepository {
        return ProductsRepositoryImpl(api)
    }


    @Provides
    fun providesConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }

    @Provides
    fun providesRetrofit(converterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(UtilConstants.BASE_URL)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}