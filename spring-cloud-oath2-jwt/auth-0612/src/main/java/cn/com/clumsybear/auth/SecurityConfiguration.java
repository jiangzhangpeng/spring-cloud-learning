package cn.com.clumsybear.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	// 请配置这个，以保证在刷新Token时能成功刷新
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		// 配置用户来源于数据库
		// 配置密码加密方式 BCryptPasswordEncoder，添加用户加密的时候请也用这个加密
		/*
		 * auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser(
		 * "user_1") .password("123456").authorities("USER");
		 * auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser(
		 * "user_2") .password("123456").authorities("USER");
		 */
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		// 自定义service从数据库查询
		return userDetailsService;

		// 这里是添加两个用户到内存中去，实际中是从#下面去通过数据库判断用户是否存在
		// InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

		// String pwd = passwordEncoder.encode("123456");
		// manager.createUser(User.withUsername("user_1").password(pwd).authorities("USER").build());
		// manager.createUser(User.withUsername("user_2").password(pwd).authorities("USER").build());
		// return manager;

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.requestMatchers().anyRequest().and().authorizeRequests().antMatchers("/oauth/**").permitAll();
		// @formatter:on
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String args[]) {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
}
