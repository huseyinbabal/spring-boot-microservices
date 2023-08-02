package com.example.inventory;

import java.util.Map;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
class InventoryController {

	private final Map<String, InventoryStatus> statuses = Map.of("1", new InventoryStatus(true), "2", new InventoryStatus(false));

	@GetMapping("/inventories")
	public InventoryStatus getInventory(@RequestParam("productId") String productId) {
		return this.statuses.getOrDefault(productId, new InventoryStatus(false));
	}
}

@Data
@AllArgsConstructor
class InventoryStatus {
	private boolean exists;
}
