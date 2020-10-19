package part_2

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun countCommission_VKPay() {

        val amount = 13000.00
        val previousAmount = 100.00
        val cartType = "Vk Pay"

        val result = countCommission(
            amount = amount,
            previousAmount = previousAmount,
            cartType = cartType
        )

        assertEquals(result, 0.0, 0.0);
    }

    @Test
    fun countCommission_cartTypeMaestroInLimit() {

        val amount = 13000.00
        val previousAmount = 100.00
        val cartType = "MAESTRO"

        val result = countCommission(
            amount = amount,
            previousAmount = previousAmount,
            cartType = cartType
        )

        assertEquals(result, 0.0, 0.0);
    }

    @Test
    fun countCommission_cartTypeMaestroFromLimit() {

        val amount = 88000.00
        val previousAmount = 100.00
        val cartType = "MASTER CARD"

        val result = countCommission(
            amount = amount,
            previousAmount = previousAmount,
            cartType = cartType
        )

        assertEquals(result, 72.8, 0.0);
    }

    @Test
    fun countCommission_cartTypeVisa() {

        val amount = 55000.00
        val previousAmount = 100.00
        val cartType = "VISA"

        val result = countCommission(
            amount = amount,
            previousAmount = previousAmount,
            cartType = cartType
        )

        assertEquals(result, 412.5, 0.0);
    }

    @Test
    fun countCommission_cartTypeMaestroCommission() {

        val amount = 55000.00
        val previousAmount = 100.00
        val cartType = "Vk Pay"

        val result = countCommission(
            amount = amount,
            previousAmount = previousAmount,
            cartType = cartType
        )

        assertEquals(result, 0.0, 0.0);
    }

    @Test
    fun checkLimits_VKPay() {

        val amount = 13000.00
        val previousAmount = 100.00
        val cartType = "Vk Pay"

        val result = checkLimits(cartType, previousAmount, amount)
        assertEquals(result, false)

    }

    @Test
    fun checkLimits_AmountMoreVKMaxAmount() {

        val amount = 180000.00
        val previousAmount = 100.00
        val cartType = "MAESTRO"

        val result = checkLimits(cartType, previousAmount, amount)
        assertEquals(result, true)

    }

    @Test
    fun checkLimits_AmountPlusPreviousAmountMoreVKMaxAmount() {

        val amount = 180000.00
        val previousAmount = 300000.00
        val cartType = "MAESTRO"

        val result = checkLimits(cartType, previousAmount, amount)
        assertEquals(result, true)

    }

    @Test
    fun checkLimits_OtherPaySystem() {

        val amount = 13000.00
        val previousAmount = 100.00
        val cartType = "MAESTRO"

        val result = checkLimits(cartType, previousAmount, amount)
        assertEquals(result, false)

    }

    @Test
    fun makeTransfer() {

        val amount = 210000.00
        val previousAmount = 500.00
        val cartType = "MAESTRO"

        val result = makeTransfer(cartType, previousAmount, amount)

        assertEquals(result, kotlin.Unit)

    }

    @Test
    fun makeTransfer_NoLimit() {

        val amount = 10000.00
        val previousAmount = 500.00
        val cartType = "MAESTRO"

        val result = makeTransfer(cartType, previousAmount, amount)

        assertEquals(result, kotlin.Unit)

    }
}