package controller;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;

public class ReservaController {

    private ReservaDAO reservaDAO;

    public ReservaController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.reservaDAO = new ReservaDAO(connection);
    }

    public void cadastrar(Reserva reserva) {
        this.reservaDAO.cadastrar(reserva);
    }

    public Reserva buscarPorId(int id) {
        return reservaDAO.buscarReservaPorId(id);
    }

    public void deletarReserva(int id) {
        reservaDAO.deletar(id);
    }

    public void alterarReserva(Date dataE, Date dataS, BigDecimal valor, String formaPagamento, Integer id){
        this.reservaDAO.alterar(dataE,dataS,valor,formaPagamento,id);
    }
}
