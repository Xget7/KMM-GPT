//
//  MessageField.swift
//  iosApp
//
//  Created by Juan Andrade on 07/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct MessageField: View {
    var onSendMessage : (String) -> Void
    @State private var message = ""

    var body: some View {
        HStack {
            // Custom text field created below
            CustomTextField(placeholder: Text("Enter your message here"), text: $message)
                .frame(height: 52)
                .disableAutocorrection(true)

            Button {
                onSendMessage(message)
                message = ""
            } label: {
                Image(systemName: "paperplane.fill")
                    .foregroundColor(.white)
                    .padding(10)
                    .background(peachColor)
                    .cornerRadius(50)
            }
        }
        .padding(.horizontal)
        .padding(.vertical, 10)
        .background(lightGreyColor)
        .cornerRadius(50)
        .padding()
    }
}

//struct MessageField_Previews: PreviewProvider {
//    static var previews: some View {
//        MessageField()
//    }
//}


struct CustomTextField: View {
    var placeholder: Text
    @Binding var text: String
    var editingChanged: (Bool)->() = { _ in }
    var commit: ()->() = { }

    var body: some View {
        ZStack(alignment: .leading) {
            // If text is empty, show the placeholder on top of the TextField
            if text.isEmpty {
                placeholder
                .opacity(0.5)
            }
            TextField("", text: $text, onEditingChanged: editingChanged, onCommit: commit)
        }
    }
}
