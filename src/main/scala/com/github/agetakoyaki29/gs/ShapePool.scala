package com.github.agetakoyaki29.gs

import javafx.collections.ObservableList
import javafx.collections.FXCollections
import com.github.agetakoyaki29.gs.shape.Shape


class ShapePool {
  val pool = FXCollections.emptyObservableList[Shape]
}