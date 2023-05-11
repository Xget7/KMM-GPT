//
//  LoadingScreen.swift
//  iosApp
//
//  Created by Juan Andrade on 05/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct LoadingScreen: View {
    var body: some View {
          VStack {
              Spacer()
              Text("loading...")
              Spacer().frame(height: 30)
              ProgressView().progressViewStyle(CircularProgressViewStyle())
              Spacer()
          }
      }
}

struct LoadingScreen_Previews: PreviewProvider {
    static var previews: some View {
        LoadingScreen()
    }
}
