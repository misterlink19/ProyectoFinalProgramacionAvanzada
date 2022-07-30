package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.handler.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product.DeleteProductCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CommandEvent(command = DeleteProductCommand.class)
@Slf4j
public class DeleteProductCommandHandler implements CommandHandler<DeleteProductResponse, DeleteProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public DeleteProductResponse handle(DeleteProductCommand deleteProductCommand) {
        productRepository.deleteById(deleteProductCommand.getId());
        log.info("Product {} deleted", deleteProductCommand.getId());
        return DeleteProductResponse.builder()
                .build();
    }
}
