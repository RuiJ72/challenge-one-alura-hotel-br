package modelo;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Reserva {
    private int id;
    private Date dataEntrada;
    private Date dataSaida;
    private BigDecimal valor;
    private String formaPagamento;

    public Reserva(Date dataEntrada, Date dataSaida, BigDecimal valor, String formaPagamento) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    /**
     * Constructor
     */
    public Reserva() {
    }

    /**
     * Getters and Setters
     * @return
     */

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public Date getDataEntrada() {

        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {

        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {

        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {

        this.dataSaida = dataSaida;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {

        this.valor = valor;
    }

    public String getFormaPagamento() {

        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {

        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", valor=" + valor +
                ", formaPagamento=" + formaPagamento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id == reserva.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


