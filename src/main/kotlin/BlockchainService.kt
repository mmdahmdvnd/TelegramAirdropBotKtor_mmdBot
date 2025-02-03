package ir.androidmaterial

import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.crypto.Credentials
import org.web3j.tx.RawTransactionManager
import org.web3j.tx.Transfer
import org.web3j.utils.Convert
import java.math.BigDecimal

object BlockchainService {
    private val web3j = Web3j.build(HttpService("https://mainnet.infura.io/v3/YOUR_INFURA_PROJECT_ID"))

    fun sendTokens(walletAddress: String, amount: String) {
        val credentials = Credentials.create("YOUR_PRIVATE_KEY")
        val transactionManager = RawTransactionManager(web3j, credentials)

        try {
            val bigDecimalAmount = BigDecimal(amount) // تبدیل رشته به BigDecimal

            val txReceipt = Transfer.sendFunds(
                web3j, credentials, walletAddress, bigDecimalAmount, Convert.Unit.ETHER
            ).send()

            println("✅ Transaction successful! Hash: ${txReceipt.transactionHash}")
        } catch (e: Exception) {
            println("❌ Transaction failed: ${e.message}")
        }
    }
}

