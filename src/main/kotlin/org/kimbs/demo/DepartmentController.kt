package org.kimbs.demo

import org.kimbs.demo.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class DepartmentController(private val departmentRepository: DepartmentRepository) {

    @GetMapping("/department")
    fun findAll(): MutableList<*> = departmentRepository.findAll();

    @GetMapping("/department/{departmentName}")
    fun findByDepartmentName(@PathVariable departmentName: String) = departmentRepository.findByDepartmentName(departmentName);

    @PostMapping("/department")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveDepartment(@RequestBody department: Department) = departmentRepository.saveAndFlush(department);

    @DeleteMapping("/department/{departmentId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteDepartment(@PathVariable departmentId: Long) {
        val deleted = departmentRepository.findById(departmentId).orElseThrow { ResourceNotFoundException("Wrong department id provided"); }
        departmentRepository.deleteById(deleted.departmentId);
    }

    @PutMapping("/department/{departmentId}")
    fun updateDepartment(@PathVariable departmentId: Long, @RequestBody department: Department): Department {
        var updated = departmentRepository.findById(departmentId).orElseThrow { ResourceNotFoundException("Wrong department id provided"); }

        updated.departmentName = department.departmentName;
        updated.office = department.office;

        return departmentRepository.saveAndFlush(updated);
    }
}