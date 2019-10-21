package org.kimbs.demo.exception

import java.time.ZonedDateTime

data class ErrorResponse(val timestamp: ZonedDateTime, val status: String, val message: String, val details: String)