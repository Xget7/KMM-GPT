//
//  MessagesListRow.swift
//  iosApp
//
//  Created by Juan Andrade on 07/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MessageBubble: View {
    
    var item : Message
    var dateString : String
        
    
    init(item: Message) {
        self.item = item
        
        let date = NSDate(timeIntervalSince1970: Double(item.date)!)

        let dayTimePeriodFormatter = DateFormatter()
        dayTimePeriodFormatter.dateFormat = "hh:mm"

        dateString = dayTimePeriodFormatter.string(from: date as Date)

    }
 
    
        var body: some View {
            
            VStack(alignment: .trailing) {
                HStack {
                    if 	(item.message != "-LOADING-LOADING"){
                        Text(item.message)
                            .padding()
                            .background(item.author != "me" ? lightGreyColor : peachColor)
                            .cornerRadius(30)
                    }else {
                        TypeWriterView(text: "...")
                    }
                    
                }
                .frame(maxWidth: 300, alignment: item.author != "me" ? .leading : .trailing)
            
                
                if(item.message != "-LOADING-LOADING"){
                    Text("\(dateString)")
                            .font(.caption2)
                            .foregroundColor(.gray)
                            .padding(item.author != "me" ? .leading : .trailing, 25)
                }
            
                
            }
            .frame(maxWidth: .infinity, alignment: item.author != "me" ? .leading : .trailing)
            .padding(item.author != "me" ? .leading : .trailing)
            .padding(.horizontal, 10)
        }
}

