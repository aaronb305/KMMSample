package com.example.firstcomposemultiplatorm.viewModels

import com.arkivanov.essenty.instancekeeper.InstanceKeeper

open class ViewModel: InstanceKeeper.Instance {
    override fun onDestroy() {
        TODO("Not yet implemented")
        // clean up here
    }
}