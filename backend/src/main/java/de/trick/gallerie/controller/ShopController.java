package de.trick.gallerie.controller;


import de.trick.connector.mail.service.MailService;
import de.trick.gallerie.dto.CartDTO;
import de.trick.gallerie.dto.ProductListDTO;
import de.trick.gallerie.dto.SidebarDTO;
import de.trick.gallerie.entity.Product;
import de.trick.gallerie.service.CategoryService;
import de.trick.gallerie.service.ProductService;
import de.trick.gallerie.type.ColorType;
import de.trick.gallerie.type.OrderType;
import de.trick.gallerie.type.PicturesizeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/shop")
public class ShopController {

    private static final Logger LOG = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MailService mailService;

    @Autowired
    private Environment environment;


    @GetMapping(path = "/sidebar-list")
    public ResponseEntity<SidebarDTO> getSidebar() {
        SidebarDTO sidebar = new SidebarDTO();
        sidebar.getFeaturedProducts().add(new Product());
        sidebar.getSidebarList().addAll(this.categoryService.loadCategories(true));
        ResponseEntity<SidebarDTO> responseEntity = ResponseEntity.ok().body(sidebar);
        return responseEntity;
    }

    @GetMapping(path = "")
    public ResponseEntity<ProductListDTO> getProductList(
            @RequestParam(name = "per_page", required = false, defaultValue = "1")Integer perPage,
            @RequestParam(name = "page", required = false, defaultValue = "1")Integer page,
            @RequestParam(name = "order_by", required = false, defaultValue = "default")OrderType orderBy,
            @RequestParam(name = "category", required = false)String categoryUuid,
            @RequestParam(name = "color", required = false)ColorType[] colors,
            @RequestParam(name = "size", required = false)PicturesizeType[] sizes
            ) {
        page--;
        Page<Product> result = this.productService.loadProducts(page, perPage, true, orderBy.getDatabaseName(), colors, sizes, categoryUuid);
        ProductListDTO productList = new ProductListDTO();
        result.get().forEach(product -> productList.getProducts().add(product));
        productList.setTotalCount((int) result.getTotalElements());
        ResponseEntity<ProductListDTO> responseEntity = ResponseEntity.ok().body(productList);
        return responseEntity;
    }

    @PostMapping(path = "/submitCart", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> submitCart(@RequestBody CartDTO cartDTO) {
        LOG.info(cartDTO.getNachricht());

        Map<String, Object> rootMap = new HashMap<String, Object>();
        rootMap.put("cart", cartDTO);
        try {
            //this.sendConfirmationMail(cartDTO, "mail/templates/orderConfirmationCustomer_de.ftl", cartDTO.getEmail(), environment.getRequiredProperty("mail.message.orderConfirmationCustomer.subject"));
            this.sendConfirmationMail(cartDTO, "mail/templates/orderConfirmationShopowner_de.ftl", environment.getRequiredProperty("mail.message.orderConfirmationShopowner.receiver"), environment.getRequiredProperty("mail.message.orderConfirmationShopowner.subject"));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Fehler beim versenden der E-Mail: " + e.getMessage());
        }

        return ResponseEntity.ok().body("Vielen Dank für Ihre Anfrage, ich werde mich schnellsmöglich melden.");
    }

    private void sendConfirmationMail(CartDTO cartDTO, String templateName, String receiver, String subject) throws Exception {
        Map<String, Object> rootMap = new HashMap<String, Object>();
        rootMap.put("cart", cartDTO);
        try {
            this.mailService.sendMessage(templateName, rootMap, environment.getRequiredProperty("mail.message.orderConfirmation.sender"), receiver, subject);
        }
        catch (Exception e){
            LOG.error("Error sending email to " + receiver, e);
            throw e;
        }
    }

}
