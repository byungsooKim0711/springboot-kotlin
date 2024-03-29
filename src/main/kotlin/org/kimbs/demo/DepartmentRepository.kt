package org.kimbs.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository : JpaRepository<Department, Long> {
    fun findByDepartmentName(departmentName: String): Iterable<Department>;
}