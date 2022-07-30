package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.handler.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product.GetAllProductCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Product;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.ProductDTO;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllProductCommand.class)
@Slf4j
public class GetAllProductCommandHandler implements CommandHandler<GetProductResponse, GetAllProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public GetProductResponse handle(GetAllProductCommand getAllProductCommand) {
        log.debug("Get Products {}", getAllProductCommand.toString());
        List<ProductDTO> productDTOS = productRepository.findAll()
                .stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
        return GetProductResponse.builder()
                .products(productDTOS)
                .build();
    }
}
