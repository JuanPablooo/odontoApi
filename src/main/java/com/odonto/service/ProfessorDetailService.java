package com.odonto.service;

import com.odonto.model.GenericUserDetails;
import com.odonto.model.Usuario;
import com.odonto.repository.DentistaRepository;

import com.odonto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// ProfessorDetailService implements UserDetailsService

@Service
public class ProfessorDetailService implements UserDetailsService {

    @Autowired
    DentistaRepository dentistaRepository;

    @Autowired
    private UsuarioRepository acessoRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Usuario> acesso = acessoRepository.findByLogin(s);

        acesso.orElseThrow(() -> new UsernameNotFoundException("Professor não encontrado: " + s));

        List<String> lista = new ArrayList<>();

        return acesso.map(GenericUserDetails::new).get();
    }

}
