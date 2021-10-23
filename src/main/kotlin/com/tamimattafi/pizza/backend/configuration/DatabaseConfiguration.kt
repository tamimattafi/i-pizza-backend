package com.tamimattafi.pizza.backend.configuration

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration
import dev.miku.r2dbc.mysql.MySqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import java.time.Duration

@Configuration
class DatabaseConfiguration : AbstractR2dbcConfiguration() {

    override fun connectionFactory(): ConnectionFactory {
        val configuration = MySqlConnectionConfiguration.builder()
                .host(DATABASE_HOST)
                .port(DATABASE_PORT)
                .username(DATABASE_USERNAME)
                .password(DATABASE_PASSWORD)
                .database(DATABASE_NAME)
                .connectTimeout(Duration.ofSeconds(TIMEOUT_IN_SECONDS))
                .useServerPrepareStatement()
                .build()

        return MySqlConnectionFactory.from(configuration)
    }

    private companion object {
        const val DATABASE_HOST = "127.0.0.1"
        const val DATABASE_PORT = 3306
        const val DATABASE_USERNAME = "root"
        const val DATABASE_PASSWORD = "root"
        const val DATABASE_NAME = "i-pizza-db"
        const val TIMEOUT_IN_SECONDS = 20L
    }
}
