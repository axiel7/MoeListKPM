import Foundation
import UIKit
import shared

class AppDelegate: NSObject, UIApplicationDelegate {
    // Run initializers on app launch
    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]? = nil
    ) -> Bool {
        Main_iosKt.doInitApp()
        return true
    }
}
