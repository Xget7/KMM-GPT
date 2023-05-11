import SwiftUI
import shared

@main
struct iOSApp: App {
    @StateObject var appObj = AppObservableObject()
    @Environment(\.scenePhase) var scenePhase
    
    var body: some Scene {
            WindowGroup {
                Router()
                    .environmentObject(appObj)
                    .onChange(of: scenePhase) { newPhase in
                        if newPhase == .active {
                            appObj.dkmpNav.onReEnterForeground()
                        }
                        else if newPhase == .background {
                            appObj.dkmpNav.onEnterBackground()
                        }
                    }
            }
        }
}
