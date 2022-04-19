package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.AcessorioDAOImpl;
import br.com.fiap.jpa.dao.impl.CarroDAOImpl;
import br.com.fiap.jpa.dao.impl.ModeloDAOImpl;
import br.com.fiap.jpa.entity.Acessorio;
import br.com.fiap.jpa.service.GenericService;

public class CarroServiceImpl extends GenericService<Carro, Long> {

private static CarroServiceImpl instance = null;
	
	private CarroDAOImpl carroDAO;
	
	private CarroServiceImpl() {
		carroDAO = CarroDAOImpl.getInstance();
	}
	
	public static CarroServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new CarroServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Carro instance) {
		try {
			carroDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Carro instance) {
		try {
			carroDAO.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			carroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Carro obter(Long id) {
		Carro carro = null;
		
		try {
			carro = carroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return carro;
	}

	@Override
	public List<Carro> listar() {
		List<Carro> carros = null;
		
		try {
			carros = carroDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return carros;
	}

}
