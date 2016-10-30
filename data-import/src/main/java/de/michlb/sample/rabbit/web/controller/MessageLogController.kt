package de.michlb.sample.rabbit.web.controller

import de.michlb.sample.rabbit.repositories.MessageLogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

/**
 * Created by admin on 30.10.16.
 */
@Controller
class MessageLogController {

    @Autowired
    lateinit var messageLogrepository:MessageLogRepository

    @GetMapping("/messages")
    fun showLog(model:Model):String {
        var logMessages = messageLogrepository.findAll().reversed()
        model.addAttribute("logMessages", logMessages)
        return "messageLog"
    }
}