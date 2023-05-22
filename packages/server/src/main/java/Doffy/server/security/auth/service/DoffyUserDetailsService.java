package Doffy.server.security.auth.service;

import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import Doffy.server.security.auth.utils.DoffyAuthorityUtils;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class DoffyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final DoffyAuthorityUtils doffyAuthorityUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new BusinessLogicException(ExceptionCode.USER_NOT_FOUND);
        }
        Collection<? extends GrantedAuthority> authorities = doffyAuthorityUtils.createAuthorities(user.getUsername());
                return new DoffyUserDetails(user);
    }

    private final class DoffyUserDetails extends User implements UserDetails{
        DoffyUserDetails(User user){
            setUserId(user.getUserId());
            setUsername(user.getUsername());
            setName(user.getName());
            setPassword(user.getPassword());
            setNickname(user.getNickname());
            setRoles(user.getRoles());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return doffyAuthorityUtils.createAuthorities(this.getRoles());
        }
        @Override
        public String getUsername(){
            return super.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
