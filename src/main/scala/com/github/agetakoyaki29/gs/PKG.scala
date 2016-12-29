package com.github.agetakoyaki29.gs

import javafx.event.Event
import javafx.event.EventHandler


object PKG {
  implicit def f2eh[T <: Event](f: T => Unit) = new EventHandler[T] {
    def handle(event: T) = f(event)
  }
  
}
