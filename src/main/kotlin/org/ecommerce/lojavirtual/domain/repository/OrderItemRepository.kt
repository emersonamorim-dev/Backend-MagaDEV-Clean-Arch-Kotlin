import org.ecommerce.lojavirtual.domain.entity.OrderItemEntity
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface OrderItemRepository : JpaRepository<OrderItemEntity, UUID>
