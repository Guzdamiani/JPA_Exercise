/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistence;

import java.util.List;
import libreria.entities.Libro;

/**
 *
 * @author guzma
 */
public class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    public void eliminar(Long isbn) throws Exception {
        Libro libro = buscarPorIsbn(isbn);
        super.eliminar(libro);
    }

    public List<Libro> listarTodos() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return libros;
    }

    public Libro buscarPorIsbn(Long isbn) throws Exception {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn").setParameter("isbn", isbn).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro buscarPorTitulo(String titulo) throws Exception {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo").setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libro;
    }
}
