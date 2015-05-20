package com.swimcr.servicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swimcr.dao.UsuarioDao;
import com.swimcr.modelos.Rol;
import com.swimcr.modelos.Usuario;

@Configurable
@Service("userService")
public class ServicioUsuarios implements UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.obtenerPorNombreUsuario(username);
		List<GrantedAuthority> authorities = buildUserAuthority(usuario
				.getRol());

		return buildUserForAuthentication(usuario, authorities);

	}

	// Converts com.mkyong.users.model.Usuario Usuario to
	// org.springframework.security.core.userdetails.Usuario
	private User buildUserForAuthentication(Usuario usuario,
			List<GrantedAuthority> authorities) {
		return new User(usuario.getNombre_usuario(), usuario.getContrasena(),
				usuario.isActivo(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Rol> roles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (Rol rol : roles) {
			setAuths.add(new SimpleGrantedAuthority(rol.getRol()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}
}
