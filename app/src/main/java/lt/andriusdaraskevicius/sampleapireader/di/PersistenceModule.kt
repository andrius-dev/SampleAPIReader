package lt.andriusdaraskevicius.sampleapireader.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lt.andriusdaraskevicius.sampleapireader.data.persistence.AppDatabase
import lt.andriusdaraskevicius.sampleapireader.data.persistence.PostsDao
import lt.andriusdaraskevicius.sampleapireader.util.AppConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room
                .databaseBuilder(application, AppDatabase::class.java, AppConfig.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun providePostsDao(database: AppDatabase): PostsDao {
        return database.postsDao()
    }


}