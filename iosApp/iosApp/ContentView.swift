
import SwiftUI
import shared

@available(iOS 15.0.0, *)
struct ContentView: View {

    private let locationManager = LocationPermissionManager()
    
    private let viewModel = LocationViewModel()
    @State private var address: String = "No address found"
    
    var body: some View {
        VStack {
            Text(address)
                .padding()
            Button(
                action: {
                    if locationManager.hasLocationPermission() {
                        viewModel.loadAddress()
                    } else {
                        locationManager.requestLocationPermission(onAuthorized: {
                            viewModel.loadAddress()
                        })
                    }},
                label: {
                    Text("Search address")
                }
            )
        }
        .onAppear {
            registerObservers()
        }
    }
    
    private func registerObservers() {
        viewModel.address.collect(
            collector: FlowCollector<String > { (foundAddress: String) in
                self.address = foundAddress
            }
        ) { e in
            
            if let exception = e {
                print("Finished \(exception).")
            }else {
                print("Finished without exception.")
            }
        }
    }
}
