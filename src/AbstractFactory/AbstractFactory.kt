package AbstractFactory
import java.lang.IllegalArgumentException

interface Sala{
    fun getAlunos() : List<Aluno>
    fun getProfessorOrientador() : Professor
    fun getMaterias() : List<Materia>
    fun getLiderDeSala() : Aluno
}

data class Aluno(
    val idAluno: Int,
    val nomeAluno: String
)

data class Professor(
    val idProfessor: Int,
    val nomeProfessor: String,
    val Materia: Materia
)

data class Materia(
    val idMateria: Int,
    val nomeMateria: String
)

abstract class AnoLetivoFactory{
    abstract fun getSalaDeAnoLetivo() : Sala

    companion object {
        inline fun <reified T : Sala> create() : AnoLetivoFactory =
            when (T::class){
                PrimeiroAnoLetivo::class -> PrimeiroAnoFactory()
                SegundoAnoLetivo::class -> SegundoAnoFactory()
                else -> throw IllegalArgumentException()
            }
    }
}

class SegundoAnoFactory : AnoLetivoFactory() {
    override fun getSalaDeAnoLetivo(): Sala = SegundoAnoLetivo()

}

class PrimeiroAnoFactory : AnoLetivoFactory(){
    override fun getSalaDeAnoLetivo() = PrimeiroAnoLetivo()
}

class PrimeiroAnoLetivo : Sala {

    override fun getAlunos(): List<Aluno> {
        return listOf(
            Aluno(1,"Eduardo"),
            Aluno(2, "Maeli"),
            Aluno(3, "Vinicius"),
            Aluno(4, "Ana"),
            Aluno(5, "Sérgio"),
            Aluno(6, "Elen"),
            Aluno(6, "Natale"),
            Aluno(6, "Amanda")
        )
    }

    override fun getProfessorOrientador(): Professor {
        return Professor(1, "girafalez",
            Materia(1, "Matemática")
        )
    }

    override fun getMaterias(): List<Materia> {
        return listOf(
            Materia(1, "matemática"),
            Materia(2, "Programação"),
            Materia(3, "Gramática")
        )
    }

    override fun getLiderDeSala(): Aluno {
        return Aluno(1, "Eduardo")
    }
}

class SegundoAnoLetivo : Sala {
    override fun getAlunos(): List<Aluno> {
        return listOf(
            Aluno(1,"Eduardo"),
            Aluno(3, "Sérgio"),
            Aluno(3, "Elen"),
            Aluno(3, "Luis"),
            Aluno(3, "Flavia"),
            Aluno(3, "Vivi cookies"),
            Aluno(3, "Pedro rocker")

        )
    }

    override fun getProfessorOrientador(): Professor {
        return Professor(1, "Mauricio",
            Materia(1, "Artes plásticas")
        )
    }

    override fun getMaterias(): List<Materia> {
        return listOf(
            Materia(1, "Psicologia aplicada"),
            Materia(2, "Introdução a literatura clássica"),
            Materia(3, "Filosofia aplicada")
        )
    }

    override fun getLiderDeSala(): Aluno {
        return Aluno(1, "Eduardo")
    }
}

fun main(){
    //sem o companion object:
    val alunosPrimeiroAno = PrimeiroAnoFactory().getSalaDeAnoLetivo().getAlunos()
    val professorPrimeiroAno = PrimeiroAnoFactory().getSalaDeAnoLetivo().getProfessorOrientador()
    val materiasPrimeiroAno = PrimeiroAnoFactory().getSalaDeAnoLetivo().getMaterias()
    val LiderDeSalaPrimeiroAno = PrimeiroAnoFactory().getSalaDeAnoLetivo().getLiderDeSala()

    println()
    println()

    println("Primeiro ano letivo:")
    println(alunosPrimeiroAno)
    println(professorPrimeiroAno)
    println(materiasPrimeiroAno)
    println(LiderDeSalaPrimeiroAno)

    println()
    println()

    //com o companion object:
    println("segundo ano letivo:")
    println(AnoLetivoFactory.create<SegundoAnoLetivo>().getSalaDeAnoLetivo().getAlunos())
    println(AnoLetivoFactory.create<SegundoAnoLetivo>().getSalaDeAnoLetivo().getProfessorOrientador())
    println(AnoLetivoFactory.create<SegundoAnoLetivo>().getSalaDeAnoLetivo().getMaterias())
    println(AnoLetivoFactory.create<SegundoAnoLetivo>().getSalaDeAnoLetivo().getLiderDeSala())
}
