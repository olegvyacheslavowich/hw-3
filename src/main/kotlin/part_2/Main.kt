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

    val maxAmountMasterCardMaestro = 75000.00
    val masterCardMaestroCommissionPercent = 0.06
    val masterCardMaestroCommissionValue = 20.00
    val visaCommissionPercent = 0.75
    val visaMinCommissionValue = 35.00

    return when (cartType) {
        "MASTER CARD", "MAESTRO" -> {
            return when (amount + previousAmount) {
                in 0.0..maxAmountMasterCardMaestro -> 0.00
                else -> (amount * masterCardMaestroCommissionPercent / 100) + masterCardMaestroCommissionValue
            }
        }
        "VISA", "МИР" -> {
            val commission = amount * visaCommissionPercent / 100
            return if (commission < visaMinCommissionValue) visaMinCommissionValue else commission
        }
        else -> 0.00
    }

}

fun checkLimits(cartType: String, previousAmount: Double, amount: Double): Boolean {

    val vkMaxAmountPerDay = 15_000.00
    val vkMaxAmountPerMouth = 40_000.00
    val maxAmountPerDay = 150_000.00
    val maxAmountPerMouth = 600_000.00

    return if (cartType == "Vk Pay") {
        amount > vkMaxAmountPerDay || previousAmount + amount > vkMaxAmountPerMouth
    } else {
        amount > maxAmountPerDay || previousAmount + amount > maxAmountPerMouth
    }
}