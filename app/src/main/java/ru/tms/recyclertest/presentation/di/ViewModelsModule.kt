package ru.tms.recyclertest.presentation.di

import org.koin.dsl.module
import ru.tms.recyclertest.presentation.ChooseMessageViewModel

val viewModelsModule = module {

    single<ChooseMessageViewModel> {
        ChooseMessageViewModel(
            interactor = get()
        )
    }

}