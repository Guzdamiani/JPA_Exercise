/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistence;

import java.util.List;
import libreria.entities.Autor;

/**
 *
 * @author guzma
 */
public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    public void eliminar(Integer id) throws Exception {
        Autor autor = buscarPorId(id);
        super.eliminar(autor);
    }

    public List<Autor> listarTodos() throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return autores;
    }

    public Autor buscarPorId(Integer id) throws Exception {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
        desconectar();
        return autor;
    }

    public Autor buscarPorNombre(String nombre) throws Exception {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;
    }
}
