package by.hometrainng.yourbeer.koin

import by.hometrainng.yourbeer.viewModels.DetailsViewModel
import by.hometrainng.yourbeer.viewModels.ListViewModel
import by.hometrainng.yourbeer.viewModels.RandomBeerViewModel
import by.hometrainng.yourbeer.viewModels.BreweryMapViewModel
import by.hometrainng.yourbeer.viewModels.BottomSheetInfoViewModel

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::ListViewModel)
//    viewModel { (id: Int) -> DetailsViewModel(id, get()) }
    viewModelOf(::DetailsViewModel)
    viewModelOf(::RandomBeerViewModel)
    viewModelOf(::BreweryMapViewModel)
    viewModelOf(::BottomSheetInfoViewModel)


}