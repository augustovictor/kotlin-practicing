package delegate

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Installment {
    var calculatedValue: BigDecimal by InstallmentValueCalculator()
}

class InstallmentValueCalculator: ReadWriteProperty<Installment, BigDecimal> {
    var backingField = BigDecimal.ZERO

    override fun getValue(thisRef: Installment, property: KProperty<*>): BigDecimal {
        return backingField
    }

    override fun setValue(thisRef: Installment, property: KProperty<*>, value: BigDecimal) {
        backingField = value.setScale(2, RoundingMode.HALF_EVEN)
    }
}

fun main(args: Array<String>) {
    val installment = Installment()
    println(installment.calculatedValue)
    installment.calculatedValue = 10.0348.toBigDecimal()
    println(installment.calculatedValue)
}
