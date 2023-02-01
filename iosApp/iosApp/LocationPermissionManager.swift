//
//  LocationPermissionManager.swift
//  iosApp
//
//  Created by Thiago Monteiro on 31/01/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import CoreLocation
import CoreLocationUI

class LocationPermissionManager: NSObject, CLLocationManagerDelegate {
    
    private var onAuthorizedCallback: (() -> Void)?  = nil
    
    let manager: CLLocationManager = CLLocationManager()
    
    override init() {
        super.init()
        manager.delegate = self
    }
    
    func hasLocationPermission() -> Bool {
        switch(manager.authorizationStatus) {
        case CLAuthorizationStatus.authorized,
            CLAuthorizationStatus.authorizedAlways,
            CLAuthorizationStatus.authorizedWhenInUse:
            return true;
        default  :
            return false ;
        }
    }
    
    func requestLocationPermission(onAuthorized: @escaping () -> Void ) {
        self.onAuthorizedCallback = onAuthorized
        manager.requestWhenInUseAuthorization()
    }
    
    internal func locationManagerDidChangeAuthorization(_ manager: CLLocationManager) {
        if(hasLocationPermission()) {
            self.onAuthorizedCallback?()
            self.onAuthorizedCallback = nil
        }
    }
}
