package ru.vsu.cs.masalkin.internet_shop.api.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vsu.cs.masalkin.internet_shop.api.model.ProductDto;
import ru.vsu.cs.masalkin.internet_shop.app.controller.ProductController;

@Controller
public class AdminProductsController {

    @Autowired
    private ProductController productController;

    @GetMapping("/AdminProducts")
    public String Products(Model model) {
        Iterable<ProductDto> products = productController.findAll();
        model.addAttribute("products", products);
        return "AdminProducts";
    }

    @GetMapping("/AdminProducts/searchProduct")
        public String searchProduct(@RequestParam("title") String title, Model model) {
        Iterable<ProductDto> products = productController.findByTitle(title);
        model.addAttribute("products", products);
        return "AdminProducts";
    }

    @PostMapping("/AdminProducts/saveProduct")
    public String saveProduct(@ModelAttribute("newProduct") ProductDto product) {
        productController.save(product);
        return "redirect:/AdminProducts";
    }

    @PostMapping("/AdminProducts/editProduct")
    public String editProduct(@ModelAttribute("product") ProductDto product) {
        productController.save(product);
        return "redirect:/AdminProducts";
    }

    @PostMapping("/AdminProducts/deleteProduct")
    public String deleteProduct(@ModelAttribute("id") Integer id) {
        productController.delete(id);
        return "redirect:/AdminProducts";
    }
}
