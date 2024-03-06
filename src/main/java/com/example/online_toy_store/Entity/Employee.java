package com.example.online_toy_store.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @Column(name = "e_id")
    private UUID eId;

    private User user;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "date_of_dismissal")
    private LocalDate dateOfDismissal;

    private Set<Order> employeeOrders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(eId, employee.eId) && Objects.equals(hireDate, employee.hireDate) && Objects.equals(dateOfDismissal, employee.dateOfDismissal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eId, hireDate, dateOfDismissal);
    }
}
