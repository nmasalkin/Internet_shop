package ru.vsu.cs.masalkin.internet_shop.api.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vsu.cs.masalkin.internet_shop.api.model.CartItem;
import ru.vsu.cs.masalkin.internet_shop.api.model.ProductDto;
import ru.vsu.cs.masalkin.internet_shop.app.controller.ProductController;

import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    private ProductController productController;

    @GetMapping("/Catalog")
    public String Catalog(Model model) {
        Iterable<ProductDto> products = productController.findAll();
        model.addAttribute("products", products);
        return "Catalog";
    }

    @GetMapping("/Catalog/searchProduct")
    public String searchProduct(@RequestParam("title") String title, Model model) {
        Iterable<ProductDto> products = productController.findByTitle(title);
        model.addAttribute("products", products);
        return "Catalog";
    }
}
