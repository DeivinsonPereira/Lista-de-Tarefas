package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.TaskList;
import com.deivinson.listatarefas.entities.Usuario;

public class TaskListDTOTest {

	private TaskListDTO listaTarefaDTO;
	
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		
		listaTarefaDTO = new TaskListDTO();
	}
	
	@Test
	public void testSetAndGetId() {
		
		listaTarefaDTO.setId(1L);
		assertEquals(1L, listaTarefaDTO.getId());
	}
	
	@Test
	public void testSetAndGetDataInclusao() {
		
		Instant instanteEsperado = Instant.now();
		
		listaTarefaDTO.setDataInclusao(instanteEsperado);
		
		assertEquals(instanteEsperado, listaTarefaDTO.getDataInclusao());
	}
	
	@Test
	public void testSetAndGetVencimento() {
		
		Instant instanteEsperado = Instant.now();
		
		listaTarefaDTO.setVencimento(instanteEsperado);
		
		assertEquals(instanteEsperado, listaTarefaDTO.getVencimento());
	}
	
	@Test
	public void testEstaConcluida() {
		
		listaTarefaDTO.setConcluida(true);
		
		assertTrue(listaTarefaDTO.isConcluida());
	}
	
	@Test
	public void testSetAndIsConcluida() {
		
		listaTarefaDTO.setConcluida(false);
		
		assertFalse(listaTarefaDTO.isConcluida());
	}
	
		
	@Test
	public void testEntityToDTOConversion() {
		
		
		usuario = new Usuario(1L, "Joelson", 30, "joelson@gmail.com");
		
		TaskList listaTarefa = new TaskList(1L, "Teste", Instant.now(), usuario);
		
		TaskListDTO listatarefaDTO = new TaskListDTO(listaTarefa);
		
		assertEquals(listatarefaDTO.getId(), listaTarefa.getId());
		assertEquals(listatarefaDTO.getTitulo(), listaTarefa.getTitulo());
		assertEquals(listatarefaDTO.getDataInclusao(), listaTarefa.getDataInclusao());
		assertEquals(listatarefaDTO.isConcluida(), listaTarefa.isConcluida());
		assertEquals(listatarefaDTO.getUsuarioDto().getNome(), listaTarefa.getUsuario().getNome());
	}
	
	@Test
	public void constructorWithAllArguments() {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setNome("João");
		
		TaskListDTO listaTarefaDTO = new TaskListDTO(1L, "Mercado",  Instant.now(), usuarioDTO);
		
		assertEquals(1L, listaTarefaDTO.getId());
		assertEquals("Mercado", listaTarefaDTO.getTitulo());
		assertEquals(Instant.now(), listaTarefaDTO.getDataInclusao());
		assertEquals(Instant.now(), listaTarefaDTO.getVencimento());
		assertFalse(listaTarefaDTO.isConcluida() == true);
		assertEquals(usuarioDTO.getNome(), listaTarefaDTO.getUsuarioDto().getNome() );
		
	}
	
	@Test
	public void testSetter() {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setNome("João");
		
		TaskListDTO listaTarefaDTO = new TaskListDTO();
		listaTarefaDTO.setId(1L);
		listaTarefaDTO.setTitulo("Mercado");
		listaTarefaDTO.setUsuarioDto(usuarioDTO);
		
		assertEquals(1L, listaTarefaDTO.getId());
		assertEquals("Mercado", listaTarefaDTO.getTitulo());
		assertEquals(usuarioDTO.getNome(), listaTarefaDTO.getUsuarioDto().getNome() );
	}

}