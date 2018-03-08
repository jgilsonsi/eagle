package com.jjdev.eagle.api.controllers;

import com.jjdev.eagle.api.dtos.JOrderDto;
import com.jjdev.eagle.api.entities.JClient;
import com.jjdev.eagle.api.entities.JEquipmentModel;
import com.jjdev.eagle.api.entities.JOrder;
import com.jjdev.eagle.api.response.JResponse;
import com.jjdev.eagle.api.services.IOrderService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JGilson
 */
@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin(origins = "*")
public class JOrderController {

    @Autowired
    private IOrderService orderService;

    private static final Logger log = LoggerFactory.getLogger(JOrderController.class);

    public JOrderController() {
    }

    /**
     * Create order.
     *
     * @param order
     * @param result
     * @return ResponseEntity<JResponse<JOrderDto>>
     */
    @PostMapping
    public ResponseEntity<JResponse<JOrderDto>> create(
            @Valid @RequestBody JOrderDto orderDto, BindingResult result) {

        log.info("Creating order.");

        JResponse<JOrderDto> response = new JResponse<>();
        if (result.hasErrors()) {
            log.info("Validation erros: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors()
                    .add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        JOrder order = this.dtoToOrder(orderDto);
        order = this.orderService.create(order);

        response.setData(this.orderToDto(order));
        return ResponseEntity.ok(response);
    }

    /**
     * Return a list of orders.
     *
     * @return ResponseEntity<Response<List<JOrderDto>>>
     */
    @GetMapping(value = "")
    public ResponseEntity<JResponse<List<JOrderDto>>> readAll() {

        log.info("Searching all orders.");

        JResponse<List<JOrderDto>> response = new JResponse<>();

        List<JOrder> orders = this.orderService.readAll();
        List<JOrderDto> ordersDto = orders.stream()
                .map(order -> this.orderToDto(order))
                .collect(Collectors.toList());

        response.setData(ordersDto);
        return ResponseEntity.ok(response);
    }

    /**
     * Update order.
     *
     * @param id
     * @param orderDto
     * @return ResponseEntity<JResponse<JOrderDto>>
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<JResponse<JOrderDto>> update(@PathVariable("id") Long id,
            @Valid @RequestBody JOrderDto orderDto, BindingResult result) {

        log.info("Updating order: {}", id);

        JResponse<JOrderDto> response = new JResponse<>();

        if (result.hasErrors()) {
            log.info("Validation errors: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        orderDto.setId(id);
        JOrder order = this.dtoToOrder(orderDto);
        order = this.orderService.update(order);

        response.setData(this.orderToDto(order));
        return ResponseEntity.ok(response);
    }

    /**
     * Delete order by id.
     *
     * @param id
     * @return ResponseEntity<JResponse<String>>
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<JResponse<String>> delete(@PathVariable("id") Long id) {

        log.info("Removing order by id: {}", id);

        JResponse<String> response = new JResponse<>();
        Optional<JOrder> order = this.orderService.readById(id);

        if (!order.isPresent()) {
            log.info("Invalid order id: {}", id);
            response.getErrors().add("Invalid order id: " + id);
            return ResponseEntity.badRequest().body(response);
        }

        this.orderService.delete(id);

        return ResponseEntity.ok(new JResponse<>());
    }

    //--------------------------------------------------------------------------
    /**
     * Convert DTO to JOrder.
     *
     * @param orderDto
     * @return JOrder
     */
    private JOrder dtoToOrder(JOrderDto orderDto) {

        JClient client = new JClient();
        client.setId(orderDto.getClientId());

        JEquipmentModel equipmentModel = new JEquipmentModel();
        equipmentModel.setId(orderDto.getEquipmentModelId());

        JOrder order = new JOrder();
        order.setId(orderDto.getId());
        order.setInitialDate(orderDto.getInitialDate());
        order.setFinalDate(orderDto.getFinalDate());
        order.setValue(orderDto.getValue());
        order.setClient(client);
        order.setEquipmentModel(equipmentModel);

        return order;
    }

    /**
     * Convert JOrder to DTO.
     *
     * @param order
     * @return JOrderDto
     */
    private JOrderDto orderToDto(JOrder order) {

        JOrderDto orderDto = new JOrderDto();
        orderDto.setId(order.getId());
        orderDto.setInitialDate(order.getInitialDate());
        orderDto.setFinalDate(order.getFinalDate());
        orderDto.setValue(order.getValue());
        orderDto.setClientId(order.getClient().getId());
        orderDto.setEquipmentModelId(order.getEquipmentModel().getId());

        return orderDto;
    }

}
