package ir.reza_mahmoudi.myfilm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.reza_mahmoudi.myfilm.data.search.remote.SearchApi
import ir.reza_mahmoudi.myfilm.data.search.repository.SearchRepositoryImpl
import ir.reza_mahmoudi.myfilm.domain.search.SearchRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object SearchModule {

    @Singleton
    @Provides
    fun provideSearchApi(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSearchRepository(productApi: SearchApi) : SearchRepository {
        return SearchRepositoryImpl(productApi)
    }
}