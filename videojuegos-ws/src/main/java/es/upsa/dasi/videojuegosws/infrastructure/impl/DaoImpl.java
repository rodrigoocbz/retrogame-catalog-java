package es.upsa.dasi.videojuegosws.infrastructure.impl;

import es.upsa.dasi.domain.exceptions.VideoJuegoRunTimeException;
import es.upsa.dasi.videojuegosws.infrastructure.Dao;
import es.upsa.dasi.videojuegosws.infrastructure.dto.VideojuegoRow;
import jakarta.inject.Inject;

import jakarta.enterprise.context.ApplicationScoped;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;







@ApplicationScoped
public class DaoImpl implements Dao {
    @Inject
    DataSource dataSource;

    @Override
    public VideojuegoRow insert(VideojuegoRow videojuegoRow) {
        final String SQL = """
                            INSERT INTO videojuegos_retro (titulo, precio, stock, fecha_lanzamiento, codigo_serial, correo_proveedor, valoracion, categoria, url_imagen)
                                                VALUES(        ?,    ?,      ?,                ?,              ?,                  ?,          ?,          ?,          ?)
                            """;
        final String[] FIELDS = {"codigo"};

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL,FIELDS)){
            preparedStatement.setString(1, videojuegoRow.getTitulo());
            preparedStatement.setDouble(2, videojuegoRow.getPrecio());
            preparedStatement.setInt(3, videojuegoRow.getStock());
            preparedStatement.setDate(4, Date.valueOf(videojuegoRow.getFechaLanzamiento()));
            preparedStatement.setString(5, videojuegoRow.getCodigoSerial());
            preparedStatement.setString(6, videojuegoRow.getCorreoProveedor());
            preparedStatement.setDouble(7, videojuegoRow.getValoracion());
            preparedStatement.setString(8, videojuegoRow.getCategoria());
            preparedStatement.setString(9, videojuegoRow.getUrlImagen());
            preparedStatement.executeUpdate();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                resultSet.next();
                return VideojuegoRow.builder()
                        .codigo(resultSet.getLong(1))
                        .titulo(videojuegoRow.getTitulo())
                        .precio(videojuegoRow.getPrecio())
                        .stock(videojuegoRow.getStock())
                        .fechaLanzamiento(videojuegoRow.getFechaLanzamiento())
                        .codigoSerial(videojuegoRow.getCodigoSerial())
                        .correoProveedor(videojuegoRow.getCorreoProveedor())
                        .valoracion(videojuegoRow.getValoracion())
                        .categoria(videojuegoRow.getCategoria())
                        .urlImagen(videojuegoRow.getUrlImagen())
                        .build();
            }

        }catch (SQLException sqlException){
            throw  new VideoJuegoRunTimeException(sqlException);
        }
    }

    @Override
    public List<VideojuegoRow> getAll() {
        final String SQL = """
                            SELECT *
                            FROM videojuegos_retro
                            """;
        List<VideojuegoRow> videojuegoRows = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                videojuegoRows.add(VideojuegoRow.builder()
                                .codigo(resultSet.getLong(1))
                                .titulo(resultSet.getString(2))
                                .precio(resultSet.getDouble(3))
                                .stock(resultSet.getInt(4))
                                .fechaLanzamiento(resultSet.getDate(5).toLocalDate())
                                .codigoSerial(resultSet.getString(6))
                                .correoProveedor(resultSet.getString(7))
                                .valoracion(resultSet.getDouble(8))
                                .categoria(resultSet.getString(9))
                                .urlImagen(resultSet.getString(10))
                                                .build());
            }

        }catch (SQLException sqlException){
            throw   new VideoJuegoRunTimeException(sqlException);
        }

        return  videojuegoRows;
    }

    @Override
    public Optional<VideojuegoRow> getById(long codigo) {
        final String SQL = """
                            SELECT * 
                            FROM videojuegos_retro
                            WHERE codigo = ?
                            """;
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setLong(1, codigo);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if (!resultSet.next()) return  Optional.empty();
                return Optional.of(VideojuegoRow.builder()
                                .codigo(resultSet.getLong(1))
                                .titulo(resultSet.getString(2))
                                .precio(resultSet.getDouble(3))
                                .stock(resultSet.getInt(4))
                                .fechaLanzamiento(resultSet.getDate(5).toLocalDate())
                                .codigoSerial(resultSet.getString(6))
                                .correoProveedor(resultSet.getString(7))
                                .valoracion(resultSet.getDouble(8))
                                .categoria(resultSet.getString(9))
                                .urlImagen(resultSet.getString(10))
                                                .build());
            }

        }catch (SQLException sqlException){
            throw   new VideoJuegoRunTimeException(sqlException);
        }
    }

    @Override
    public Optional<VideojuegoRow> updateGame(VideojuegoRow videojuegoRow) {
        final String SQL = """
                            UPDATE videojuegos_retro
                            SET titulo = ?,
                             precio = ?,
                             stock = ?,
                             fecha_lanzamiento = ?,
                             codigo_serial = ?,
                             correo_proveedor = ?,
                             valoracion = ?,
                             categoria = ?,
                             url_imagen = ?
                           WHERE codigo = ?
                            """;
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, videojuegoRow.getTitulo());
            preparedStatement.setDouble(2, videojuegoRow.getPrecio());
            preparedStatement.setInt(3, videojuegoRow.getStock());
            preparedStatement.setDate(4,Date.valueOf(videojuegoRow.getFechaLanzamiento()));
            preparedStatement.setString(5,videojuegoRow.getCodigoSerial());
            preparedStatement.setString(6,videojuegoRow.getCorreoProveedor());
            preparedStatement.setDouble(7,videojuegoRow.getValoracion());
            preparedStatement.setString(8,videojuegoRow.getCategoria());
            preparedStatement.setString(9,videojuegoRow.getUrlImagen());
            preparedStatement.setLong(10,videojuegoRow.getCodigo());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated == 0) return  Optional.empty();
            return  Optional.of(videojuegoRow);
        }catch (SQLException sqlException){
            throw   new VideoJuegoRunTimeException(sqlException);
        }
    }

    @Override
    public int delete(long codigo) {
        final String SQL = """
                        DELETE FROM videojuegos_retro
                        WHERE codigo = ?
                        """;
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setLong(1, codigo);
            return  preparedStatement.executeUpdate();

        }catch (SQLException sqlException){
            throw    new VideoJuegoRunTimeException(sqlException);
        }
    }
}
