/*package tomi.coderhouse.jpa.services;

import tomi.coderhouse.jpa.entities.Invoice;
import tomi.coderhouse.jpa.entities.InvoiceDetail;
import tomi.coderhouse.jpa.entities.Product;
import tomi.coderhouse.jpa.exceptions.InsufficientStockException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import tomi.coderhouse.jpa.entities.Client;
import tomi.coderhouse.jpa.repositories.ProductRepository;
import tomi.coderhouse.jpa.repositories.ClientRepository;

@SpringBootTest
public class InvoiceServiceTest {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testCreateInvoiceWithSufficientStock() throws InsufficientStockException {
        Client client = new Client();
        client.setId(UUID.randomUUID().toString());
        client.setName("Tomás");
        client.setLastName("Milano");
        client.setDocNumber("41799421");

        clientRepository.save(client);

        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setDescription("Producto de prueba");
        product.setCodigo("sdf4sd4ws3");
        product.setStock(10);
        product.setPrice(100.0);

        productRepository.save(product);

        InvoiceDetail detail = new InvoiceDetail();
        detail.setProduct(product);
        detail.setAmount(2);

        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setDetails(List.of(detail));

        Invoice createdInvoice = invoiceService.createInvoice(invoice);

        assertNotNull(createdInvoice);
        assertEquals(2, createdInvoice.getDetails().get(0).getAmount());
    }

    @Test
    void testCreateInvoiceWithInsufficientStock() {
        Client client = clientRepository.findById("49d7fb2e-1435-41a2-8cc2-020bfeeb4151").orElseThrow(
                () -> new RuntimeException("Cliente no encontrado en la base de datos"));

        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setDescription("Producto de prueba");
        product.setCodigo("sdf4sd4ws3");
        product.setStock(1);
        product.setPrice(100.0);
        productRepository.save(product);

        InvoiceDetail detail = new InvoiceDetail();
        detail.setProduct(product);
        detail.setAmount(2);

        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setDetails(List.of(detail));

        assertThrows(InsufficientStockException.class, () -> invoiceService.createInvoice(invoice));
    }

}*/
