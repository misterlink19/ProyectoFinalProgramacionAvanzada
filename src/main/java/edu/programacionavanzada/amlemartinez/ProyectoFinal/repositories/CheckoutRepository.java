package edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {
}
