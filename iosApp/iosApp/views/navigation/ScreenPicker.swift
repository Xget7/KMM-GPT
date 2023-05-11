//
//  ScreenPicker.swift
//  iosApp
//
//  Created by Juan Andrade on 07/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared



extension Navigation {
    
    
    @ViewBuilder func screenPicker(requestedSId: ScreenIdentifier) -> some View {
        
        VStack {
        
            switch requestedSId.screen {
            
            case .chatscreen:
                ChatScreen(
                    chatState: self.stateProvider.getToCast(screenIdentifier: requestedSId) as! ChatState,
                    onSendMessage: { msg in self.events.sendMessage(message: msg)}
                )
                
    
            default:
                EmptyView()
            }
            
        }
        .navigationTitle(getTitle(screenIdentifier: requestedSId))
        .navigationBarTitleDisplayMode(.inline)
        .onAppear { if requestedSId.URI == self.navigationState.topScreenIdentifier.URI {
            NSLog("iOS side:  onAppear URI "+requestedSId.URI)
        } }
        .onDisappear {
            self.exitScreenForIos(screenIdentifier: requestedSId)
        }
        
        
    }
    
    
    
    @ViewBuilder func twoPaneDefaultDetail(level1ScreenIdentifier: ScreenIdentifier) -> some View {
        
        switch level1ScreenIdentifier.screen {

        default:
            EmptyView()
        }
        
    }
    
    
}

