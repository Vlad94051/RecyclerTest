package ru.tms.recyclertest.presentation.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.tms.recyclertest.data.di.DATA_SOURCE_QUALIFIER
import ru.tms.recyclertest.presentation.ChooseMessageViewModel

val viewModelsModule = module {

    viewModel {
        ChooseMessageViewModel(
            interactor = get(qualifier = DATA_SOURCE_QUALIFIER)
        )
    }

}