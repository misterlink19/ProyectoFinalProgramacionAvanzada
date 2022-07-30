package edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.CheckoutProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CheckoutProductRepository extends JpaRepository<CheckoutProduct, Long> {
}
