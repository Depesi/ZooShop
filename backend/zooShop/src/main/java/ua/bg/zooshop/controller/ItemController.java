package ua.bg.zooshop.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.Item;
import ua.bg.zooshop.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    ItemService service;

    @ApiOperation(value = "Get List with all Items")
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/")
    public List<Item> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get one Item by id")
    @GetMapping("/{id}")
    public Item getById(@PathVariable(value = "id") Integer id) {
        return service.getById(id);
    }
    @GetMapping(value = "/findByName/{name}")
    public Item getfindByName(@PathVariable(value = "name") String name){return service.getFindByName(name);}

    @ApiOperation(value = "Method that creates Items")
    @PostMapping("/")
    public Item create(@RequestBody Item item) {
        return service.create(item);
    }

    @ApiOperation(value = "Method that updates Items")
    @PutMapping("/")
    public Item update(@RequestBody Item item) {
        return service.update(item);
    }

    @ApiOperation(value = "Method that removes Items by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")int id){
        service.delete(id);
    }
}
