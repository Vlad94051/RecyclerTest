package ru.tms.recyclertest.data.di

import org.koin.dsl.module
import ru.tms.recyclertest.data.DataSource
import ru.tms.recyclertest.domain.ChatInteractor

val dataModule = module {
    single<ChatInteractor> {
        DataSource()
    }
}