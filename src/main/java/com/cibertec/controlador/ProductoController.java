package com.cibertec.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.modelo.Producto;
import com.cibertec.repositorio.IProductoRepositorio;

@Controller
public class ProductoController {
	@Autowired
    private IProductoRepositorio productoRepository;

    @GetMapping("/")
    public String listarproductos(Model model) {
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "listarproductos";
    }
    
    @GetMapping("/buscar")
    public String buscarProductosPorDescripcion(@RequestParam(name = "descripcion", required = false) String descripcion,
                                                Model model) {
        if (descripcion != null && !descripcion.isEmpty()) {
            List<Producto> productos = productoRepository.buscarPorDescripcion(descripcion);
            model.addAttribute("productos", productos);
        }
        return "consulta"; 
    }
}
