package dao;

import modelo.Reserva;

import java.math.BigDecimal;
import java.sql.*;

public class ReservaDAO {

    private Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Reserva reserva) {

        String sql = "INSERT INTO reservas (data_entrada, data_saida, valor, forma_pagamento) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setDate(1, Date.valueOf(reserva.getDataEntrada().toLocalDate()));
            pstm.setDate(2, Date.valueOf(reserva.getDataSaida().toLocalDate()));
            pstm.setBigDecimal(3, reserva.getValor());
            pstm.setString(4, reserva.getFormaPagamento());

            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    reserva.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível inserir a reserva: " + e.getMessage());
        }
    }

    public Reserva buscarReservaPorId(int id) {
        String sql = "SELECT * FROM reservas WHERE id = ?";
        Reserva reserva = null;
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    reserva = new Reserva();
                    reserva.setId(rs.getInt("id"));
                    reserva.setDataEntrada(rs.getDate("data_entrada"));
                    reserva.setDataSaida(rs.getDate("data_saida"));
                    reserva.setValor(rs.getBigDecimal("valor"));
                    reserva.setFormaPagamento(rs.getString("forma_pagamento"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar reserva por ID: " + e.getMessage());
        }
        return reserva;
    }

    public void deletar(Integer id) {
        try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM reservas WHERE ID = ?")) {
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Date dataE, Date dataS, BigDecimal valor, String formPagamento, Integer id) {
        try (PreparedStatement pstm = connection.prepareStatement("UPDATE reservas r SET r.data_entrada = ?, r.data_saida = ?, valor = ?, forma_pagamento = ? WHERE ID = ?")) {
            pstm.setDate(1, dataE);
            pstm.setDate(2, dataS);
            pstm.setBigDecimal(3, valor);
            pstm.setString(4, formPagamento);
            pstm.setInt(5, id);
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
