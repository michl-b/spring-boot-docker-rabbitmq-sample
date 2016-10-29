package de.michlb.sample.rabbit.web.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by admin on 28.10.16.
 */
@Controller
class SendController {

    @RequestMapping("/send", method = arrayOf(RequestMethod.GET))
    fun show(): String {
        return "send"
    }
}
