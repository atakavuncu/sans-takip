package com.example.sanstakip.ui.homepage

import com.example.sanstakip.base.BaseEvents
import com.example.sanstakip.model.SayisalSuperModel

sealed class HomePageEvent: BaseEvents {
    data class SelectedLotoModel(
        var data: SayisalSuperModel
    ): HomePageEvent()
}
