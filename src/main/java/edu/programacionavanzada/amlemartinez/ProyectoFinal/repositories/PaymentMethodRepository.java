package edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
