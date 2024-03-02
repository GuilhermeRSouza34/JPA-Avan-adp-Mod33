/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.domain.Curso;
import br.com.rpires.domain.Matricula;

public interface IMatriculaDao {

	Matricula cadastrar(Matricula mat);

	Matricula buscarPorCodigoCurso(String codigoCurso);

	Matricula buscarPorCurso(Curso curso);

	Matricula buscarPorCodigoCursoCriteria(String codigoCurso);

	Matricula buscarPorCursoCriteria(Curso curso);

}
