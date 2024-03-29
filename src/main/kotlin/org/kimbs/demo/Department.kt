package org.kimbs.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Department (
          @Id
          @GeneratedValue
          val departmentId: Long
        , var departmentName: String
        , var office: String
)