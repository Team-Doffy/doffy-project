package Doffy.server.security.auth.config;


import Doffy.server.security.auth.filter.JwtAuthenticationFilter;
import Doffy.server.security.auth.filter.JwtVerificationFilter;
import Doffy.server.security.auth.handler.OAuth2MemberSuccessHandler;
import Doffy.server.security.auth.handler.UserAuthenticationEntryPoint;
import Doffy.server.security.auth.handler.UserAuthenticationFailureHandler;
import Doffy.server.security.auth.handler.UserAuthenticationSuccessHandler;
import Doffy.server.security.auth.jwt.JwtTokenizer;
import Doffy.server.security.auth.utils.DoffyAuthorityUtils;
import Doffy.server.security.auth.utils.UserAccessDeniedHandler;
import Doffy.server.user.repository.UserRepository;
import Doffy.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Value("${spring.security.oauth2.client.registration.google.clientId}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.clientSecret}")
    private String clientSecret;


    private final JwtTokenizer jwtTokenizer;
    private final DoffyAuthorityUtils doffyAuthorityUtils;
    private final UserService userService;
    private final UserRepository userRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable() //Cross-Site Request Forgery 옵션 비활성화
                .headers().frameOptions().disable() //별도의 headers 검증 X
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors(Customizer.withDefaults()) // cors withDefaults 사용으로 corsConfigurationSource의 빈 사용
                .formLogin().disable() //폼로그인 방식 비활성화
                .httpBasic().disable() //HTTP Basic 인증은 request를 전송할 때마다 Username/Password 정보를 HTTP Header에 실어서 인증을 하는 방식 비활성화
                .oauth2Login(Customizer.withDefaults())
                .exceptionHandling()
                .authenticationEntryPoint(new UserAuthenticationEntryPoint())
                .accessDeniedHandler(new UserAccessDeniedHandler())
                .and()
                .apply(new CustomFilterConfigurer())
                .and()
              .authorizeHttpRequests(authorize -> authorize // url authorization 전체 추가
//                        .antMatchers(HttpMethod.POST, "/*/members").permitAll()    // OAuth 2로 로그인하므로 회원 정보 등록 필요 없음.
//                        .antMatchers(HttpMethod.PATCH, "/*/members/**").hasRole("USER") // OAuth 2로 로그인하므로 회원 정보 수정 필요 없음.
//                        .antMatchers(HttpMethod.GET, "/*/members").hasRole("ADMIN")  // OAuth 2로 로그인하므로 회원 정보 수정 필요 없음.
//                        .antMatchers(HttpMethod.GET, "/*/members/**").hasAnyRole("USER", "ADMIN")  // OAuth 2로 로그인하므로 회원 정보 수정 필요 없음.
//                        .antMatchers(HttpMethod.DELETE, "/*/members/**").hasRole("USER") // OAuth 2로 로그인하므로 회원 정보 수정 필요 없음.
//                        .antMatchers(HttpMethod.POST, "/*/coffees").hasRole("ADMIN")
//                        .antMatchers(HttpMethod.PATCH, "/*/coffees/**").hasRole("ADMIN")
//                        .antMatchers(HttpMethod.GET, "/*/coffees/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.GET, "/*/coffees").permitAll()
//                        .antMatchers(HttpMethod.DELETE, "/*/coffees").hasRole("ADMIN")
//                        .antMatchers(HttpMethod.POST, "/*/orders").hasRole("USER")
//                        .antMatchers(HttpMethod.PATCH, "/*/orders").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.GET, "/*/orders/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.DELETE, "/*/orders").hasRole("USER")
                        .anyRequest().permitAll()
            )
            .oauth2Login(oauth2 -> oauth2
                    .successHandler(new OAuth2MemberSuccessHandler(jwtTokenizer,doffyAuthorityUtils,userService,userRepository)) // (1)
            );

        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return urlBasedCorsConfigurationSource;
    }

    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer,HttpSecurity>{
        @Override
        public void configure(HttpSecurity builder) throws Exception{
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtTokenizer);
            jwtAuthenticationFilter.setFilterProcessesUrl("/api/v1/signin");
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new UserAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new UserAuthenticationFailureHandler());
            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer,doffyAuthorityUtils);
            builder
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class)
                    .addFilterAfter(jwtVerificationFilter,  OAuth2LoginAuthenticationFilter.class);
        }
    }
}
