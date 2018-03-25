package ru.nix13.renamer

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.TextField
import javafx.stage.Stage

class Main: Application() {
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("rename.fxml"))
        primaryStage.scene = Scene(root)
        primaryStage.isResizable = false
        primaryStage.maxHeight = 210.0
        primaryStage.maxWidth = 280.0
        primaryStage.title = "Renamer"
        primaryStage.show()
        Controller.name_filed = root.lookup("#name_field") as TextField
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }
}

