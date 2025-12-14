package desafios.desafio_03

fun main() {
    val estoque = Estoque()
    var continuar = true

    while (continuar) {
        println(
            """
            ===== Controle de Estoque =====
            1) Inserir Produto
            2) Atualizar Produto
            3) Deletar Produto
            4) Buscar Produto
            5) Listar Todos os Produtos
            6) Sair
            ===============================
        """.trimIndent()
        )

        when (processaEntradaDeDadosInteiro("Escolha uma opção:")) {
            1 -> {
                try {
                    val id = processaEntradaDeDadosInteiro("ID do produto:")
                    val nome = processaEntradaDeDadosString("Nome do produto:")
                    val preco = processaEntradaDeDadosDouble("Preço do produto:")
                    val quantidade = processaEntradaDeDadosDouble("Quantidade do produto:")
                    val produto = Produto(id, nome, preco, quantidade)
                    estoque.adicionarProduto(produto)
                } catch (e: IllegalArgumentException) {
                    println("Erro: ${e.message}")
                }
            }
            2 -> {
                try {
                    val id = processaEntradaDeDadosInteiro("Informe o ID do produto que deseja atualizar:")
                    estoque.atualizarProduto(id)
                } catch (e: IllegalArgumentException) {
                    println("Erro: ${e.message}")
                }
            }
            3 -> {
                try {
                    val id = processaEntradaDeDadosInteiro("Informe o ID do produto que deseja deletar:")
                    estoque.deletarProduto(id)
                } catch (e: IllegalArgumentException) {
                    println("Erro: ${e.message}")
                }
            }
            4 -> {
                try {
                    val id = processaEntradaDeDadosInteiro("Informe o ID do produto que deseja buscar:")
                    estoque.procurarProduto(id)
                } catch (e: IllegalArgumentException) {
                    println("Erro: ${e.message}")
                }
            }
            5 -> {
                val lista = estoque.listaDeprodutos
                if (lista.isEmpty()) {
                    println("O estoque está vazio.")
                } else {
                    println("Produtos no estoque:")
                    lista.forEach { println(it) }
                }
            }
            6 -> {
                println("Encerrando aplicação...")
                continuar = false
            }
            else -> println("Opção inválida! Tente novamente.")
        }

        println()
    }
}

class Produto(val id: Int, var nome: String, var preco: Double, var quantidade: Double) {
    override fun toString(): String {
        return "ID: $id | Nome: $nome | Preço: $preco | Quantidade: $quantidade"
    }
}

class Estoque {
    private var produtos = mutableListOf<Produto>()

    val listaDeprodutos: List<Produto>
        get() = produtos

    fun adicionarProduto(produto: Produto) {
        try {
            validarEntradaDeProdutos(produto)
            if (produtos.any { it.id == produto.id }) {
                println("Erro: Produto com ID ${produto.id} já existe.")
            } else {
                produtos.add(produto)
                println("Produto adicionado com sucesso!")
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    fun atualizarProduto(id: Int) {
        val produto = produtos.find { it.id == id }

        if (produto != null) {
            println("Atualizando produto ${produto.nome}")
            println("Novo nome (pressione Enter para manter):")
            val novoNome = readlnOrNull().takeIf { !it.isNullOrBlank() } ?: produto.nome
            println("Novo preço (pressione Enter para manter):")
            val novoPreco = readlnOrNull()?.toDoubleOrNull() ?: produto.preco
            println("Nova quantidade (pressione Enter para manter):")
            val novaQuantidade = readlnOrNull()?.toDoubleOrNull() ?: produto.quantidade

            produto.nome = novoNome
            produto.preco = novoPreco
            produto.quantidade = novaQuantidade

            println("Produto atualizado com sucesso!")
        } else {
            println("Produto com ID $id não encontrado.")
        }
    }

    fun deletarProduto(id: Int) {
        val produto = produtos.find { it.id == id }

        if (produto != null) {
            produtos.remove(produto)
            println("Produto deletado com sucesso!")
        } else {
            println("Produto com ID $id não encontrado.")
        }
    }

    fun procurarProduto(id: Int) {
        val produto = produtos.find { it.id == id }

        if (produto != null) {
            println("Produto encontrado: $produto")
        } else {
            println("Produto com ID $id não encontrado.")
        }
    }

    private fun validarEntradaDeProdutos(produto: Produto) {
        require(produto.nome.isNotBlank()) { "Nome do produto não pode ser vazio" }
        require(produto.quantidade > 0) { "Quantidade do produto deve ser maior que 0" }
        require(produto.preco > 0) { "Preço deve ser maior que 0" }
    }
}

fun processaEntradaDeDadosDouble(mensagem: String): Double {
    println(mensagem)
    return readlnOrNull()?.toDoubleOrNull()
        ?: throw IllegalArgumentException("Valor inválido")
}

fun processaEntradaDeDadosString(mensagem: String): String {
    println(mensagem)
    return readlnOrNull()
        ?: throw IllegalArgumentException("Valor inválido")
}

fun processaEntradaDeDadosInteiro(mensagem: String): Int {
    println(mensagem)
    return readlnOrNull()?.toIntOrNull()
        ?: throw IllegalArgumentException("Valor inválido")
}
