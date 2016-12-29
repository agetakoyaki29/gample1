package com.github.agetakoyaki29.gs

import javafx.application.Application
import javafx.stage.Stage

import com.github.agetakoyaki29.slidefx.StageContainer


object Main {
  def main(args: Array[String]): Unit = {
		println("helo?")
		Application.launch(classOf[SampleApp])
  }
}


class SampleApp extends Application {
	override def start(stage: Stage) = new StageContainer(stage).show(new DrawSlideController)
}
