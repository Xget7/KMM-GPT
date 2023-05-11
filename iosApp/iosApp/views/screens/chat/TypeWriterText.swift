//
//  TypeWriterText.swift
//  iosApp
//
//  Created by Juan Andrade on 10/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct TypeWriterView: View {
    @State var text: String = ""
    let finalText: String = "...."
    
    var body: some View {
        VStack(spacing: 16.0) {
            Text(text).onAppear(){
                typeWriter(at: 0)
                
            }
            
        }.frame(height: 20)
    }
    
    
    func typeWriter(at position: Int = 0) {
        if position == 0 {
            text = ""
        }
        if position < finalText.count {
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
                text.append(finalText[position])
                typeWriter(at: position + 1)
            }
        }else{
            typeWriter(at: 0)
        }
    }
    


    
}




extension String {
    subscript(offset: Int) -> Character {
        self[index(startIndex, offsetBy: offset)]
    }
}



