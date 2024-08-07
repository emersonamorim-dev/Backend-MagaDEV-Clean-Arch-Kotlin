package org.ecommerce.lojavirtual

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test") // Use this if you have a specific profile for tests
class LojaVirtualApplicationTests {
	@Test
	fun contextLoads() {
	}
}
