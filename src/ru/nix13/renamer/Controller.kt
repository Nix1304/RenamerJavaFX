package ru.nix13.renamer

import javafx.fxml.FXML
import javafx.scene.control.TextField
import java.io.File
import java.nio.file.Paths

class Controller {
    companion object {
        lateinit var name_filed: TextField
    }

    @FXML
    private fun rename(){
        val currentRelativePath = Paths.get("")
        val folder = currentRelativePath.toAbsolutePath()
        val folderFile = folder.toFile()
        val dirFiles = folderFile.listFiles()
        var count = 0
        for (file in dirFiles!!) {
            if (file.isFile) {
                count++
                val name_field = Companion.name_filed
                val splName = file.name.split("\\.".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
                val fileExt = splName[splName.size - 1]
                if (fileExt !== "") {
                    if (name_field.text.isNotEmpty()) {
                        val renameTo = File(name_field.text + "_" + count + "." + fileExt)
                        file.renameTo(renameTo)
                    }
                }
            }
        }
    }
}