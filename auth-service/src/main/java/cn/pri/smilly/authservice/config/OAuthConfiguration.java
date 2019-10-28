package cn.pri.smilly.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;

@Configuration
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource)
                .passwordEncoder(passwordEncoder)
                .withClient("custom-service")
                .secret("000000")
                .authorizedGrantTypes("authorization_code", "refresh_token", "implicit", "password", "client_credentials")
                .scopes("weball")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(2592000)
                .and()
                .withClient("user-service")
                .secret("123456")
                .authorizedGrantTypes("authorization_code", "refresh_token", "implicit", "password", "client_credentials")
                .scopes("read", "write")
                .and()
                .withClient("order-service")
                .secret("654321")
                .authorizedGrantTypes("authorization_code", "refresh_token", "implicit", "password", "client_credentials")
                .scopes("read", "write");
    }
}
