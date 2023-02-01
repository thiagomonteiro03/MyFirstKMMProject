//
//  FlowCollector.swift
//  iosApp
//
//  Created by Thiago Monteiro on 31/01/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation


import SwiftUI
import shared

@available(iOS 15.0.0, *)
class FlowCollector<T> : Kotlinx_coroutines_coreFlowCollector {
    let callback:(T) -> Void

    init(callback: @escaping (T) -> Void) {
        self.callback = callback
    }

    func emit(value: Any?) async throws -> Void   {
        if let updatedValue = value as? T {
          callback(updatedValue)
        }
        return Void()
    }
}
