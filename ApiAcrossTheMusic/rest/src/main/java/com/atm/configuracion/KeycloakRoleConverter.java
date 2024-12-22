package com.atm.configuracion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    // Esta clase será la encargada de extraer los roles del access token JWT de Keycloak para que
    // Spring Security pueda manejarlos correctamente.


    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String, Object> realmAccess = source.getClaim("realm_access");

        if (realmAccess != null || realmAccess.isEmpty())    // Map<String, Object>)
            return new ArrayList<>();

        Collection<GrantedAuthority> returnValue = ((List<String>) realmAccess.get("roles"))
                .stream().map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return returnValue;
    }
}
