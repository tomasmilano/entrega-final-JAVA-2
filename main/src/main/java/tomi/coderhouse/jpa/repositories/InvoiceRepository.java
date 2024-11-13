package tomi.coderhouse.jpa.repositories;

import tomi.coderhouse.jpa.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
}