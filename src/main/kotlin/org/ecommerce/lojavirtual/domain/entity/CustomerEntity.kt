package org.ecommerce.lojavirtual.domain.entity

import java.util.UUID
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "customers")
class CustomerEntity(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    var id: UUID? = null,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @Column(name = "address")
    var address: String? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "customer")
    var items: List<CustomerItem> = mutableListOf()
)
