package Stream;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Pedido {
    private Long id;
    private LocalDate fechaPedido;
    private LocalDate fechaEntrega;
    private String estado;
    private Cliente cliente;
    Set<Producto> productos;

    public Pedido(Long id, LocalDate fechaPedido, LocalDate fechaEntrega, String estado, Cliente cliente) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.cliente = cliente;
        this.productos = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public  void addProduct(Producto pro){
        productos.add(pro);
    }
    //class
}
