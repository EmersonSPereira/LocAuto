package br.com.emerson.locauto.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AgenciaDAOTest.class, FuncionarioDAOTest.class, VeiculoDAOTest.class,ClienteDAOTest.class })
public class AllTests {

}
