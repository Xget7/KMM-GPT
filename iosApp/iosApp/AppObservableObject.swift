//
//  AppObservableObject.swift
//  iosApp
//
//  Created by Juan Andrade on 05/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


class AppObservableObject: ObservableObject {
    let model : MyParterViewModel = MyParterViewModel.Factory().getIosInstance()
    var dkmpNav : Navigation {
        return self.appState.getNavigation(model: self.model)
    }
    @Published var appState : AppState
    @Published var localNavigationState : NavigationState
    


    init() {
        // "getDefaultAppState" and "onChange" are iOS-only DKMPViewModel's extension functions, defined in shared/iosMain
        self.appState = model.getDefaultAppState()
        self.localNavigationState = model.navigation.navigationState
        model.onChange { newState in
            self.appState = newState
            NSLog("MyParter SAMPLE: APP STATE RECOMPOSITION: index #"+String(newState.recompositionIndex))
        }
    }


}
