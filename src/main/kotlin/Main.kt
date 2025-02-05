package ir.androidmaterial

import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

fun main() {
    val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
    try {
        botsApi.registerBot(AirdropBot("8170023792:AAG8wtXbQO7MdrDipddveiEMNetWYR-dwx0"))
        println("Bot started successfully")
    } catch (e: TelegramApiException) {
        e.printStackTrace()
    }
}


