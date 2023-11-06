package uk.co.maddwarf.basicditest.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uk.co.maddwarf.basicditest.repository.JsonReader
import uk.co.maddwarf.basicditest.repository.JsonReaderImpl
import uk.co.maddwarf.basicditest.repository.MonsterRepository
import uk.co.maddwarf.basicditest.repository.MonsterRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMonsterRepository(jsonReader: JsonReader): MonsterRepository = MonsterRepositoryImpl(jsonReader)

    @Provides
    @Singleton
    fun provideJsonReader(@ApplicationContext context:Context): JsonReader = JsonReaderImpl(context)
}