package part_2

fun main() {

    val amount = 13000.00
    val previousAmount = 100.00
    val cartType = "Vk Pay"

    if (checkLimits(cartType, previousAmount, amount)) {
        print("Привышен лимит перевода")
        return
    }

    print("Комиссия за перевод: ${countCommission(cartType, previousAmount, amount)}")


}

fun countCommission(cartType: String = "Vk Pay", previousAmount: Double, amount: Double): Double {

    return when (cartType) {
        "MASTER CARD", "MAESTRO" -> {
            return when (amount + previousAmount) {
                in 0.0..75000.00 -> 0.00
                else -> (amount * 0.06 / 100) + 20.00;
            }
        }
        "VISA", "МИР" -> {
            val commission = amount * 0.75 / 100
            return if (commission < 35.00) 35.00 else commission
        }
        else -> 0.00
    }

}

fun checkLimits(cartType: String, previousAmount: Double, amount: Double): Boolean {
    return if (cartType == "Vk Pay") amount > 15_000.00 || previousAmount + amount > 40_000 else previousAmount + amount > 600_000.00
}