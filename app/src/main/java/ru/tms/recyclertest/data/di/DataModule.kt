package ru.tms.recyclertest.data.di

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import ru.tms.recyclertest.data.DataSource
import ru.tms.recyclertest.data.ServerSource
import ru.tms.recyclertest.domain.ChatInteractor

val DATA_SOURCE_QUALIFIER: Qualifier = qualifier("DATA_SOURCE_QUALIFIER")
val SERVER_SOURCE_QUALIFIER = qualifier("SERVER_SOURCE_QUALIFIER")

val dataModule = module {
    single<ChatInteractor>(qualifier = DATA_SOURCE_QUALIFIER) {
        DataSource()
    }

    single<ChatInteractor>(qualifier = SERVER_SOURCE_QUALIFIER) {
        ServerSource()
    }
}