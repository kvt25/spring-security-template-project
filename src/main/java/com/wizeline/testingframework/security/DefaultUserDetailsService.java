package com.wizeline.testingframework.security;

import com.wizeline.testingframework.persistence.model.PrivilegeModel;
import com.wizeline.testingframework.persistence.model.RoleModel;
import com.wizeline.testingframework.persistence.model.UserModel;
import com.wizeline.testingframework.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Derived user detail service to customize or override user detail service
 */
@Service("userDetailsService")
@Transactional
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    public DefaultUserDetailsService() {
        super();
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        try {
            final UserModel userModel = userRepository.findByEmail(email);
            if (userModel == null) {
                throw new UsernameNotFoundException("No user found with username: " + email);
            }

            return new User(userModel.getEmail(), userModel.getPassword(), userModel.isEnabled(),
                    true, true, true,
                                    getAuthorities(userModel.getRoles()));
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final Collection<? extends GrantedAuthority> getAuthorities(final Collection<RoleModel> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private final List<String> getPrivileges(final Collection<RoleModel> roles) {
        final List<String> privileges = new ArrayList<>();
        final List<PrivilegeModel> collection = new ArrayList<>();
        for (final RoleModel role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (final PrivilegeModel item : collection) {
            privileges.add(item.getName());
        }

        return privileges;
    }

    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
