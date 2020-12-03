package FactoryMethod
import java.lang.Exception

interface FileParser

interface FileParserFactory{
    fun createFromFileName(fileName: String) : FileParser
}

object ObjectFileParserFactory : FileParserFactory{
    override fun createFromFileName (fileName: String) =
        when (fileName.substringAfterLast('.')) {
            "xml" -> XmlFileParser()
            "json" -> JsonFileParser()
            else -> throw Exception("I don't know how to deal with $fileName.")
        }
}

fun XmlFileParser(): FileParser = XmlFile()

fun JsonFileParser(): FileParser = JsonFile()

class XmlFile : FileParser {

}

class JsonFile : FileParser {

}

fun main(){
    val objeto : ObjectFileParserFactory

}



