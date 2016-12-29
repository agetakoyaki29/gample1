package com.github.agetakoyaki29.gs

import javafx.scene.control.ScrollPane
import javafx.scene.canvas.Canvas


class GlassedCanvas extends ScrollPane {
  val hot = new Canvas
  val cold = new Canvas
  this.getChildren.addAll(hot, cold)
}
