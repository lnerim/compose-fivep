package ru.fivep.app.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.fivep.app.data.projects.ProjectDao
import ru.fivep.app.data.projects.ProjectRepository
import ru.fivep.app.data.projects.ProjectRepositoryInterface
import ru.fivep.app.data.projects.use_case.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FivePModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): FivePDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            FivePDatabase::class.java,
            "five_p_database"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideProjectRepository(fivePDatabase: FivePDatabase): ProjectRepositoryInterface =
        ProjectRepository(fivePDatabase.projectDao())

    @Provides
    @Singleton
    fun provideProjectUseCases(repository: ProjectRepositoryInterface): ProjectUseCases =
        ProjectUseCases(
            getProjects = GetProjects(repository),
            getProject = GetProject(repository),
            addProject = AddProject(repository),
            deleteProject = DeleteProject(repository)
        )

    @Provides
    @Singleton
    fun provideProjectDao(fivePDatabase: FivePDatabase): ProjectDao = fivePDatabase.projectDao()
}