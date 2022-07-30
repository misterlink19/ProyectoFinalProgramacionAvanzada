package edu.programacionavanzada.amlemartinez.ProyectoFinal.services;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product.GetAllProductCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product.GetProductCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.product.CreateProductRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.product.DeleteProductRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.product.UpdateProductRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product.CreateProductResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product.UpdateProductResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final CommandBus commandBus;

    public GetProductResponse getAll() {
        return commandBus.sendCommand(GetAllProductCommand.builder().build());
    }

    public GetProductResponse get(Long id) {
        return commandBus.sendCommand(GetProductCommand.builder().id(id).build());
    }

    public CreateProductResponse create(CreateProductRequest createProductRequest) {
        return commandBus.sendCommand(createProductRequest.toCommand());
    }

    public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
        return commandBus.sendCommand(updateProductRequest.toCommand());
    }

    public DeleteProductResponse delete(DeleteProductRequest deleteProductRequest) {
        return commandBus.sendCommand(deleteProductRequest.toCommand());
    }
}
