package aula_26_interfaces


fun main(){
    val pdfPrinter = PdfPrinter()

    val pdfDocument: Document = pdfPrinter.print("Hello Kotlin")

    println(pdfDocument)



}

data class Document(val text: String)

interface Printer {
    fun print(text:String) : Document

    val printerType: String
}

interface TextConverter {
    fun converter(text: String, printerType: String) : String
}

class PdfPrinter : Printer, TextConverter {
    override fun print(text: String): Document {
        converter(text, printerType)
        println("PDF: $text")
        return Document(text = text)
    }

    override val printerType: String
        get() = "PDF"

    override fun converter(text: String, printerType: String): String {
        println("Convertendo texto $text para o tipo $printerType...")
        return text
    }

}

class WordPrinter: Printer, TextConverter{
    override fun print(text: String): Document {
        converter(text, printerType)
        println("Word printing: $text")
        return Document(text = text)
    }

    override val printerType: String
        get() = "Word"

    override fun converter(text: String, printerType: String): String {
        println("Convertendo o texto $text  para o tipo $printerType")
        return text
    }

}