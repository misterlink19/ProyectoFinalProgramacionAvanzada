package edu.programacionavanzada.amlemartinez.ProyectoFinal.controllers;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.DemoResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.services.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    @GetMapping
    public ResponseEntity<DemoResponse> get(@RequestParam(defaultValue = "0") String explote) {
        return ResponseEntity.ok(demoService.get(explote.equals("1")));
    }
}
