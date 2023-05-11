//
//  ChatScreen.swift
//  iosApp
//
//  Created by Juan Andrade on 07/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


struct ChatScreen: View {
    var chatState : ChatState
    var onSendMessage : (String) -> Void
    
    var formatter = DateFormatter()
    var sortedMessages: [Message]


    
    init(chatState: ChatState, onSendMessage: @escaping (String) -> Void) {
        self.chatState = chatState
        self.onSendMessage = onSendMessage
        
        formatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
        
        sortedMessages = chatState.messages.sorted { (msg1, msg2) -> Bool in
            guard let date1 = Double(msg1.date), let date2 = Double(msg2.date) else {
                return false // si alguna de las fechas no se puede convertir a Double, la dejamos al final de la lista
            }
            return date1 < date2
        }
        
    }
 
   
    
    
    var body: some View {
        VStack {
            if chatState.isLoading {
                LoadingScreen()
            }else {
                
                    if chatState.messages.count == 0 {
                        HStack(spacing: 0){
                            Text("No messages")
                        }
                    }else{
                        ScrollViewReader { proxy in
                            ScrollView {
                                ForEach (sortedMessages, id: \.message) { item in
                                    MessageBubble(item: item)
                                }
                    
                            }
                            .padding(.top, 10)
                            .background(.white)
                            .onChange(of: chatState.messages) { id in
                                // When the lastMessageId changes, scroll to the bottom of the conversation
                                withAnimation {
                                    proxy.scrollTo(id, anchor: .bottom)
                                    }
                                }
                        }
                        
                        
                    }
                
                MessageField(
                    onSendMessage: onSendMessage
                )
            
            }
        }
    }
    
}

